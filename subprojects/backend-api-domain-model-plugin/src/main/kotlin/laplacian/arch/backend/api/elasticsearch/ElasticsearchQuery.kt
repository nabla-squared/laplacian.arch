package laplacian.arch.backend.api.elasticsearch
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate
import laplacian.arch.backend.api.ApiCallArgument


import laplacian.util.*

/**
 * An entity describing a elasticsearch_query.
 */
interface ElasticsearchQuery {
    /**
     * The name of this elasticsearch_query.
     */
    val name: String
    /**
     * The index_name of this elasticsearch_query.
     */
    val indexName: String
    /**
     * The description of this elasticsearch_query.
     */
    val description: String
    /**
     * The size of the page to be returned

     */
    val pageSize: String
    /**
     * Defines this elasticsearch_query is variable_page_size or not.
     */
    val variablePageSize: Boolean
    /**
     * Zero-based page index.

     */
    val pageNumber: String
    /**
     * Defines this elasticsearch_query is variable_page_number or not.
     */
    val variablePageNumber: Boolean
    /**
     * The predicate of this elasticsearch_query.
     */
    val predicate: ElasticsearchQueryPredicate?
    /**
     * The sort of this elasticsearch_query.
     */
    val sort: List<ElasticsearchQuerySort>
    /**
     * The aggregates of this elasticsearch_query.
     */
    val aggregates: List<ElasticsearchAggregate>
    /**
     * The parameters of this elasticsearch_query.
     */
    val parameters: List<ApiCallArgument>
    /**
     * Returns wether this instance is a elasticsearch_query or not.
     */
    val isaElasticsearchQuery: Boolean
}
