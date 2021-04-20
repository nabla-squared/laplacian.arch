package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.aggregate.AggregateGroupRange


import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a date_range_aggregate.
 */
data class DateRangeAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), DateRangeAggregate {

    /**
     * The format of this date_range_aggregate.
     */
    override val format: String?
        by _record
    /**
     * The ranges of this date_range_aggregate.
     */
    override val ranges: List<AggregateGroupRange> by lazy {
        AggregateGroupRangeRecord.from(_record.getList("ranges"), _context)
    }
    /**
     * Returns wether this instance is a date_range_aggregate or not.
     */
    override val isaDateRangeAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DateRangeAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DateRangeAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DateRangeAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
