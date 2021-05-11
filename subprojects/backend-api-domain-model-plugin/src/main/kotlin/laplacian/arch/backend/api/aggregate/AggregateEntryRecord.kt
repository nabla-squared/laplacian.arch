package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.Aggregate




import laplacian.generate.util.*
/**
 * An entity describing a aggregate_entry.
 */
data class AggregateEntryRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): AggregateEntry, Record by _record {

    /**
     * The name of this aggregate_entry.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this aggregate_entry.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The aggregate of this aggregate_entry.
     */
    override val aggregate: Aggregate by lazy {
        AggregateRecord.from(_context).find {
            it.name == name &&
            it.namespace == namespace
        } ?: throw IllegalStateException(
            "There is no aggregate which meets the following condition(s): "
            + "AggregateEntry.name == aggregate.name (=$name) "
            + "AggregateEntry.namespace == aggregate.namespace (=$namespace) "
            + "Possible values are: " + AggregateRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a aggregate_entry or not.
     */
    override val isaAggregateEntry: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllAggregateEntries {
            return _context.get("aggregate_entries") as AllAggregateEntries
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            AggregateEntryRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregateEntryRecord) return false
        if (name != other.name) return false
        if (namespace != other.namespace) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + namespace.hashCode()
        return result
    }

    override fun toString(): String {
        return "AggregateEntryRecord(" +
            "name=$name, " +
            "namespace=$namespace" +
        ")"
    }
}
