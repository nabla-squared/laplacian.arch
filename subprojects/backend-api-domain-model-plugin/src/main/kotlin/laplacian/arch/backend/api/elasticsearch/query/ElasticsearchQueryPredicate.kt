package laplacian.arch.backend.api.elasticsearch.query


import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_predicate.
 */
interface ElasticsearchQueryPredicate {
    /**
     * The type of this elasticsearch_query_predicate.
     */
    val type: String
    /**
     * Returns wether this instance is a elasticsearch_query_predicate or not.
     */
    val isaElasticsearchQueryPredicate: Boolean
}
