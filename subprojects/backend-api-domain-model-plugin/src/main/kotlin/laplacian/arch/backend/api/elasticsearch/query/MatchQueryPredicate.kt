package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a match_query_predicate.
 */
interface MatchQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The field of this match_query_predicate.
     */
    val field: String
    /**
     * The value of this match_query_predicate.
     */
    val value: String
    /**
     * Returns wether this instance is a match_query_predicate or not.
     */
    val isaMatchQueryPredicate: Boolean
}
