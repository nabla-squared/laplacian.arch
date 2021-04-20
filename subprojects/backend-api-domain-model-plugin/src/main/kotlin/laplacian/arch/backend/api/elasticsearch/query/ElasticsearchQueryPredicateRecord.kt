package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context


import laplacian.arch.backend.api.elasticsearch.query.BoolQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.ExistsQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.MatchAllQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.MatchQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.MultiMatchQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.QueryStringPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.RangeQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.TermQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.TermsQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query_predicate.
 */
open class ElasticsearchQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicate, Record by _record {

    /**
     * The type of this elasticsearch_query_predicate.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * Returns wether this instance is a elasticsearch_query_predicate or not.
     */
    override val isaElasticsearchQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchQueryPredicates {
            return _context.get("elasticsearch_query_predicates") as AllElasticsearchQueryPredicates
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["type"]) {
                "bool" -> BoolQueryPredicateRecord(record, _context)
                "exists" -> ExistsQueryPredicateRecord(record, _context)
                "match_all" -> MatchAllQueryPredicateRecord(record, _context)
                "match" -> MatchQueryPredicateRecord(record, _context)
                "multi_match" -> MultiMatchQueryPredicateRecord(record, _context)
                "query_string" -> QueryStringPredicateRecord(record, _context)
                "range" -> RangeQueryPredicateRecord(record, _context)
                "term" -> TermQueryPredicateRecord(record, _context)
                "terms" -> TermsQueryPredicateRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [bool, exists, match_all, match, multi_match, query_string, range, term, terms]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
