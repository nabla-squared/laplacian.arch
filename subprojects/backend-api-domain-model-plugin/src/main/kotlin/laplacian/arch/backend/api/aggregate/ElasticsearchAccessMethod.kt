package laplacian.arch.backend.api.aggregate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryCollapse
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort

import laplacian.arch.backend.api.aggregate.AggregateAccessMethod

import laplacian.util.*

/**
 * An entity describing a elasticsearch_access_method.
 */
interface ElasticsearchAccessMethod : AggregateAccessMethod {
    /**
     * The elasticsearch_client_name of this elasticsearch_access_method.
     */
    val elasticsearchClientName: String?
    /**
     * The index_name of this elasticsearch_access_method.
     */
    val indexName: String
    /**
     * From index to start the search from.

     */
    val offset: String
    /**
     * The maximum number of search hits to return.

     */
    val limit: String
    /**
     * The query of this elasticsearch_access_method.
     */
    val query: ElasticsearchQueryPredicate
    /**
     * Field collapsing on search request.

     */
    val collapse: ElasticsearchQueryCollapse?
    /**
     * The sort of this elasticsearch_access_method.
     */
    val sort: List<ElasticsearchQuerySort>
    /**
     * Returns wether this instance is a elasticsearch_access_method or not.
     */
    val isaElasticsearchAccessMethod: Boolean
}
