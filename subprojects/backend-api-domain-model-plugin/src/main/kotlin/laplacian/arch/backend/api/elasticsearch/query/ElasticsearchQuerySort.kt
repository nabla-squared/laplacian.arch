package laplacian.arch.backend.api.elasticsearch.query


import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_sort.
 */
interface ElasticsearchQuerySort {
    /**
     * The type of this elasticsearch_query_sort.
     */
    val type: String
    /**
     * The order of this elasticsearch_query_sort.
     */
    val order: String
    /**
     * Defines this elasticsearch_query_sort is variable_order or not.
     */
    val variableOrder: Boolean
    /**
     * Returns wether this instance is a elasticsearch_query_sort or not.
     */
    val isaElasticsearchQuerySort: Boolean
}
