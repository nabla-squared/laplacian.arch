package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramIntervalRecord

import laplacian.generate.util.*
/**
 * An entity describing a date_histogram_fixed_interval.
 */
data class DateHistogramFixedIntervalRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DateHistogramIntervalRecord(__record, _context), DateHistogramFixedInterval {

    /**
     * The unit of this date_histogram_fixed_interval.
     */
    override val unit: String
        get() = getOrThrow("unit")
    /**
     * The value of this date_histogram_fixed_interval.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * Returns wether this instance is a date_histogram_fixed_interval or not.
     */
    override val isaDateHistogramFixedInterval: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DateHistogramFixedIntervalRecord(record, _context)
    }
}
