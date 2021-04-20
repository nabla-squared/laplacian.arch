package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context


import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryScoreSortRecord
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryFieldSortRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query_sort.
 */
open class ElasticsearchQuerySortRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQuerySort, Record by _record {

    /**
     * The type of this elasticsearch_query_sort.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The order of this elasticsearch_query_sort.
     */
    override val order: String
        get() = getOrThrow("order") {
            "desc"
        }
    /**
     * Defines this elasticsearch_query_sort is variable_order or not.
     */
    override val variableOrder: Boolean
        get() = order?.contains("\${") ?: false
    /**
     * Returns wether this instance is a elasticsearch_query_sort or not.
     */
    override val isaElasticsearchQuerySort: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchQuerySorts {
            return _context.get("elasticsearch_query_sorts") as AllElasticsearchQuerySorts
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["type"]) {
                "score" -> ElasticsearchQueryScoreSortRecord(record, _context)
                "field" -> ElasticsearchQueryFieldSortRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [score, field]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQuerySortRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQuerySortRecord(" +
            "type=$type" +
        ")"
    }
}
