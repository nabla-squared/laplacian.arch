package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a elasticsearch_aggregate.
 */
interface ElasticsearchAggregate {
    /**
     * The name of this elasticsearch_aggregate.
     */
    val name: String
    /**
     * The description of this elasticsearch_aggregate.
     */
    val description: String
    /**
     * The aggregation_type of this elasticsearch_aggregate.
     */
    val aggregationType: String
    /**
     * The field of this elasticsearch_aggregate.
     */
    val field: String?
    /**
     * The sub_aggregates of this elasticsearch_aggregate.
     */
    val subAggregates: List<ElasticsearchAggregate>
    /**
     * Returns wether this instance is a elasticsearch_aggregate or not.
     */
    val isaElasticsearchAggregate: Boolean
}
