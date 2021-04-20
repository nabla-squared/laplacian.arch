package laplacian.arch.backend.api.elasticsearch


import laplacian.util.*

/**
 * An entity describing a elasticsearch_index_sort.
 */
interface ElasticsearchIndexSort {
    /**
     * The field of this elasticsearch_index_sort.
     */
    val field: String
    /**
     * The order of this elasticsearch_index_sort.
     */
    val order: String
    /**
     * Defines this elasticsearch_index_sort is is_numeric or not.
     */
    val isNumeric: Boolean?
    /**
     * Returns wether this instance is a elasticsearch_index_sort or not.
     */
    val isaElasticsearchIndexSort: Boolean
}
