package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySortRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query_score_sort.
 */
data class ElasticsearchQueryScoreSortRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQuerySortRecord(__record, _context), ElasticsearchQueryScoreSort {

    /**
     * Returns wether this instance is a elasticsearch_query_score_sort or not.
     */
    override val isaElasticsearchQueryScoreSort: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchQueryScoreSortRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQueryScoreSortRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQueryScoreSortRecord(" +
            "type=$type" +
        ")"
    }
}
