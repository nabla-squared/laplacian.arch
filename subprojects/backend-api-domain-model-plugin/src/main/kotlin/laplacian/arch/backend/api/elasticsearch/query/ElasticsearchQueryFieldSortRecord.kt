package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySortRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query_field_sort.
 */
data class ElasticsearchQueryFieldSortRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQuerySortRecord(__record, _context), ElasticsearchQueryFieldSort {

    /**
     * The name of this elasticsearch_query_field_sort.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * Returns wether this instance is a elasticsearch_query_field_sort or not.
     */
    override val isaElasticsearchQueryFieldSort: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchQueryFieldSortRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQueryFieldSortRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQueryFieldSortRecord(" +
            "type=$type" +
        ")"
    }
}
