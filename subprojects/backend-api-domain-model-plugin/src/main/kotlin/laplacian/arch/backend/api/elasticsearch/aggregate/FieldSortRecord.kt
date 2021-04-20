package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a field_sort.
 */
data class FieldSortRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): FieldSort, Record by _record {

    /**
     * The field of this field_sort.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * The order of this field_sort.
     */
    override val order: String?
        by _record
    /**
     * Defines this field_sort is variable_order or not.
     */
    override val variableOrder: Boolean
        get() = order?.contains("\${") ?: false
    /**
     * Returns wether this instance is a field_sort or not.
     */
    override val isaFieldSort: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllFieldSorts {
            return _context.get("field_sorts") as AllFieldSorts
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            FieldSortRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FieldSortRecord) return false
        if (field != other.field) return false
        return true
    }

    override fun hashCode(): Int {
        var result = field.hashCode()
        return result
    }

    override fun toString(): String {
        return "FieldSortRecord(" +
            "field=$field" +
        ")"
    }
}
