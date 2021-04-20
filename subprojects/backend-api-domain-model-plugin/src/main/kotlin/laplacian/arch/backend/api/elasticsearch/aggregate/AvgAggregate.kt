package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a avg_aggregate.
 */
interface AvgAggregate : ElasticsearchAggregate {
    /**
     * Returns wether this instance is a avg_aggregate or not.
     */
    val isaAvgAggregate: Boolean
}
