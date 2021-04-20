package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a duration.
 */
data class DurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Duration, Record by _record {

    /**
     * The amount of this duration.
     */
    override val amount: String
        get() = getOrThrow("amount")
    /**
     * The unit of this duration.
     */
    override val unit: String
        get() = getOrThrow("unit")
    /**
     * Returns wether this instance is a duration or not.
     */
    override val isaDuration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDurations {
            return _context.get("durations") as AllDurations
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DurationRecord(record, _context)
    }
}
