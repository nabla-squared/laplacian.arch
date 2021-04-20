package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a sum_aggregate.
 */
interface SumAggregate : ElasticsearchAggregate {
    /**
     * Returns wether this instance is a sum_aggregate or not.
     */
    val isaSumAggregate: Boolean
}
