package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate


import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a bool_query_predicate.
 */
data class BoolQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), BoolQueryPredicate {

    /**
     * The minimum_should_match of this bool_query_predicate.
     */
    override val minimumShouldMatch: String?
        by _record
    /**
     * The must of this bool_query_predicate.
     */
    override val must: List<ElasticsearchQueryPredicate> by lazy {
        ElasticsearchQueryPredicateRecord.from(_record.getList("must", emptyList()), _context)
    }
    /**
     * The must_not of this bool_query_predicate.
     */
    override val mustNot: List<ElasticsearchQueryPredicate> by lazy {
        ElasticsearchQueryPredicateRecord.from(_record.getList("must_not", emptyList()), _context)
    }
    /**
     * The should of this bool_query_predicate.
     */
    override val should: List<ElasticsearchQueryPredicate> by lazy {
        ElasticsearchQueryPredicateRecord.from(_record.getList("should", emptyList()), _context)
    }
    /**
     * The filter of this bool_query_predicate.
     */
    override val filter: List<ElasticsearchQueryPredicate> by lazy {
        ElasticsearchQueryPredicateRecord.from(_record.getList("filter", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a bool_query_predicate or not.
     */
    override val isaBoolQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            BoolQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BoolQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "BoolQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
