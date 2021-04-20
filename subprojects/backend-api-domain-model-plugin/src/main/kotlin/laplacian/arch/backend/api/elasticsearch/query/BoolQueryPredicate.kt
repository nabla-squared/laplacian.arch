package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a bool_query_predicate.
 */
interface BoolQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The must of this bool_query_predicate.
     */
    val must: List<ElasticsearchQueryPredicate>
    /**
     * The must_not of this bool_query_predicate.
     */
    val mustNot: List<ElasticsearchQueryPredicate>
    /**
     * The should of this bool_query_predicate.
     */
    val should: List<ElasticsearchQueryPredicate>
    /**
     * The filter of this bool_query_predicate.
     */
    val filter: List<ElasticsearchQueryPredicate>
    /**
     * Returns wether this instance is a bool_query_predicate or not.
     */
    val isaBoolQueryPredicate: Boolean
}
