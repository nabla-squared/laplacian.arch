package laplacian.arch.backend.api.elasticsearch.query


import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_collapse.
 */
interface ElasticsearchQueryCollapse {
    /**
     * The field of this elasticsearch_query_collapse.
     */
    val field: String
    /**
     * Returns wether this instance is a elasticsearch_query_collapse or not.
     */
    val isaElasticsearchQueryCollapse: Boolean
}
