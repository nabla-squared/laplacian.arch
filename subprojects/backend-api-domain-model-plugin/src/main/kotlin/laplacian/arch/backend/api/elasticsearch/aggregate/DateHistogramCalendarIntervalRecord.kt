package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramIntervalRecord

import laplacian.generate.util.*
/**
 * An entity describing a date_histogram_calendar_interval.
 */
data class DateHistogramCalendarIntervalRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DateHistogramIntervalRecord(__record, _context), DateHistogramCalendarInterval {

    /**
     * The unit of this date_histogram_calendar_interval.
     */
    override val unit: String
        get() = getOrThrow("unit")
    /**
     * Returns wether this instance is a date_histogram_calendar_interval or not.
     */
    override val isaDateHistogramCalendarInterval: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DateHistogramCalendarIntervalRecord(record, _context)
    }
}
