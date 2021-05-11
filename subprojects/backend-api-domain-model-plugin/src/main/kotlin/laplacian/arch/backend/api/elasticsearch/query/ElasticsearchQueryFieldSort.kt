package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort

import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_field_sort.
 */
interface ElasticsearchQueryFieldSort : ElasticsearchQuerySort {
    /**
     * Name of sorting field.

     */
    val name: String
    /**
     * Returns wether this instance is a elasticsearch_query_field_sort or not.
     */
    val isaElasticsearchQueryFieldSort: Boolean
}
