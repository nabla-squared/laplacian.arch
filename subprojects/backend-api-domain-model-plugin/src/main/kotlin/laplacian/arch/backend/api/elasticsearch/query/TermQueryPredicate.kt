package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a term_query_predicate.
 */
interface TermQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The field of this term_query_predicate.
     */
    val field: String
    /**
     * The value of this term_query_predicate.
     */
    val value: String
    /**
     * The boost of this term_query_predicate.
     */
    val boost: Int
    /**
     * Returns wether this instance is a term_query_predicate or not.
     */
    val isaTermQueryPredicate: Boolean
}
