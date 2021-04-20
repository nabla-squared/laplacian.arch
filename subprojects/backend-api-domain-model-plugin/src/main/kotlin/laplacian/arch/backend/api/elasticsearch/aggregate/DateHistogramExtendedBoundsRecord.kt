package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a date_histogram_extended_bounds.
 */
data class DateHistogramExtendedBoundsRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DateHistogramExtendedBounds, Record by _record {

    /**
     * The min of this date_histogram_extended_bounds.
     */
    override val min: String?
        by _record
    /**
     * The max of this date_histogram_extended_bounds.
     */
    override val max: String?
        by _record
    /**
     * Returns wether this instance is a date_histogram_extended_bounds or not.
     */
    override val isaDateHistogramExtendedBounds: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDateHistogramExtendedBoundses {
            return _context.get("date_histogram_extended_boundses") as AllDateHistogramExtendedBoundses
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DateHistogramExtendedBoundsRecord(record, _context)
    }
}
