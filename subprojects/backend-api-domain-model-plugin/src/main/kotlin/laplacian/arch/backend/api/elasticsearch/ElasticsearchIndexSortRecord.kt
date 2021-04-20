package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_index_sort.
 */
data class ElasticsearchIndexSortRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchIndexSort, Record by _record {

    /**
     * The field of this elasticsearch_index_sort.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * The order of this elasticsearch_index_sort.
     */
    override val order: String
        get() = getOrThrow("order") {
            "asc"
        }
    /**
     * Defines this elasticsearch_index_sort is is_numeric or not.
     */
    override val isNumeric: Boolean?
        by _record
    /**
     * Returns wether this instance is a elasticsearch_index_sort or not.
     */
    override val isaElasticsearchIndexSort: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchIndexSorts {
            return _context.get("elasticsearch_index_sorts") as AllElasticsearchIndexSorts
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchIndexSortRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchIndexSortRecord) return false
        if (field != other.field) return false
        return true
    }

    override fun hashCode(): Int {
        var result = field.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchIndexSortRecord(" +
            "field=$field" +
        ")"
    }
}
