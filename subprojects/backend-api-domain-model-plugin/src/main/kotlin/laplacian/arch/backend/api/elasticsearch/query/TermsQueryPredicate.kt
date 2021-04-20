package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a terms_query_predicate.
 */
interface TermsQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The field of this terms_query_predicate.
     */
    val field: String
    /**
     * The value of this terms_query_predicate.
     */
    val value: String
    /**
     * The boost of this terms_query_predicate.
     */
    val boost: Int
    /**
     * Returns wether this instance is a terms_query_predicate or not.
     */
    val isaTermsQueryPredicate: Boolean
}
