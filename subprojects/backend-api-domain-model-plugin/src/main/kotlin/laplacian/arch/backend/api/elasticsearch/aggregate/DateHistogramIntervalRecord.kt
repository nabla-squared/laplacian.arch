package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context


import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramCalendarIntervalRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramFixedIntervalRecord

import laplacian.generate.util.*
/**
 * An entity describing a date_histogram_interval.
 */
open class DateHistogramIntervalRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DateHistogramInterval, Record by _record {

    /**
     * The type of this date_histogram_interval.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The unit of this date_histogram_interval.
     */
    override val unit: String
        get() = getOrThrow("unit")
    /**
     * The value of this date_histogram_interval.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * Defines this date_histogram_interval is variable_unit or not.
     */
    override val variableUnit: Boolean
        get() = unit.contains("\${")
    /**
     * Defines this date_histogram_interval is variable_value or not.
     */
    override val variableValue: Boolean
        get() = value.contains("\${")
    /**
     * Returns wether this instance is a date_histogram_interval or not.
     */
    override val isaDateHistogramInterval: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDateHistogramIntervals {
            return _context.get("date_histogram_intervals") as AllDateHistogramIntervals
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["type"]) {
                "calendar" -> DateHistogramCalendarIntervalRecord(record, _context)
                "fixed" -> DateHistogramFixedIntervalRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [calendar, fixed]. Record: $record"
                )
            }
    }
}
