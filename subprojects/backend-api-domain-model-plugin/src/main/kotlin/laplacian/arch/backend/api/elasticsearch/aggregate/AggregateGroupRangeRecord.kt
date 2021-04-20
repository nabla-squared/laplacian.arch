package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a aggregate_group_range.
 */
data class AggregateGroupRangeRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): AggregateGroupRange, Record by _record {

    /**
     * The key of this aggregate_group_range.
     */
    override val key: String
        get() = getOrThrow("key")
    /**
     * The from of this aggregate_group_range.
     */
    override val from: String?
        by _record
    /**
     * The to of this aggregate_group_range.
     */
    override val to: String?
        by _record
    /**
     * Returns wether this instance is a aggregate_group_range or not.
     */
    override val isaAggregateGroupRange: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllAggregateGroupRanges {
            return _context.get("aggregate_group_ranges") as AllAggregateGroupRanges
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            AggregateGroupRangeRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregateGroupRangeRecord) return false
        if (key != other.key) return false
        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        return result
    }

    override fun toString(): String {
        return "AggregateGroupRangeRecord(" +
            "key=$key" +
        ")"
    }
}
