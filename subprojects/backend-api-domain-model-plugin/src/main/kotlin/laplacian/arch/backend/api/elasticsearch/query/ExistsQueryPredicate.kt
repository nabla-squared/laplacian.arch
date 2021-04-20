package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a exists_query_predicate.
 */
interface ExistsQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The field of this exists_query_predicate.
     */
    val field: String
    /**
     * Returns wether this instance is a exists_query_predicate or not.
     */
    val isaExistsQueryPredicate: Boolean
}
