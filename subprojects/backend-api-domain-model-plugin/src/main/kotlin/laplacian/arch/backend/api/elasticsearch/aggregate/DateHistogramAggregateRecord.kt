package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramInterval

import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramExtendedBounds


import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a date_histogram_aggregate.
 */
data class DateHistogramAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), DateHistogramAggregate {

    /**
     * The format of this date_histogram_aggregate.
     */
    override val format: String?
        by _record
    /**
     * The timezone of this date_histogram_aggregate.
     */
    override val timezone: String?
        by _record
    /**
     * the minimum document count required per bucket
     */
    override val minDocCount: String?
        by _record
    /**
     * Defines this date_histogram_aggregate is variable_min_doc_count or not.
     */
    override val variableMinDocCount: Boolean
        get() = minDocCount?.contains("\${") ?: false
    /**
     * The interval of this date_histogram_aggregate.
     */
    override val interval: DateHistogramInterval by lazy {
        DateHistogramIntervalRecord(getOrThrow<Record>("interval"), _context)
    }
    /**
     * The extended_bounds of this date_histogram_aggregate.
     */
    override val extendedBounds: DateHistogramExtendedBounds? by lazy {
        getOrNull<Record>("extended_bounds")?.let{ DateHistogramExtendedBoundsRecord.from(it, _context) }
    }
    /**
     * Returns wether this instance is a date_histogram_aggregate or not.
     */
    override val isaDateHistogramAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DateHistogramAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DateHistogramAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DateHistogramAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
