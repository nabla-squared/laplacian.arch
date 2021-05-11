package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.RestResource




import laplacian.generate.util.*
/**
 * An entity describing a rest_resource_entry.
 */
data class RestResourceEntryRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestResourceEntry, Record by _record {

    /**
     * The name of this rest_resource_entry.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this rest_resource_entry.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The rest_resource of this rest_resource_entry.
     */
    override val restResource: RestResource by lazy {
        RestResourceRecord.from(_context).find {
            it.name == name &&
            it.namespace == namespace
        } ?: throw IllegalStateException(
            "There is no rest_resource which meets the following condition(s): "
            + "RestResourceEntry.name == rest_resource.name (=$name) "
            + "RestResourceEntry.namespace == rest_resource.namespace (=$namespace) "
            + "Possible values are: " + RestResourceRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a rest_resource_entry or not.
     */
    override val isaRestResourceEntry: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestResourceEntries {
            return _context.get("rest_resource_entries") as AllRestResourceEntries
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestResourceEntryRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestResourceEntryRecord) return false
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
        return "RestResourceEntryRecord(" +
            "name=$name, " +
            "namespace=$namespace" +
        ")"
    }
}
