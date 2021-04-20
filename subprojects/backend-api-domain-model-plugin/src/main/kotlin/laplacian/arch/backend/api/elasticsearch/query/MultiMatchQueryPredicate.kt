package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a multi_match_query_predicate.
 */
interface MultiMatchQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The value of this multi_match_query_predicate.
     */
    val value: String
    /**
     * The fields of this multi_match_query_predicate.
     */
    val fields: List<String>
    /**
     * Returns wether this instance is a multi_match_query_predicate or not.
     */
    val isaMultiMatchQueryPredicate: Boolean
}
