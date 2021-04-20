package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort

import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_field_sort.
 */
interface ElasticsearchQueryFieldSort : ElasticsearchQuerySort {
    /**
     * The name of this elasticsearch_query_field_sort.
     */
    val name: String
    /**
     * Returns wether this instance is a elasticsearch_query_field_sort or not.
     */
    val isaElasticsearchQueryFieldSort: Boolean
}
