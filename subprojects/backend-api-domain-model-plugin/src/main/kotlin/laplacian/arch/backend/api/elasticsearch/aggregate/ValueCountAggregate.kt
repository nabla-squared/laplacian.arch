package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a value_count_aggregate.
 */
interface ValueCountAggregate : ElasticsearchAggregate {
    /**
     * Returns wether this instance is a value_count_aggregate or not.
     */
    val isaValueCountAggregate: Boolean
}
