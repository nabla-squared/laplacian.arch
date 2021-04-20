package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a max_aggregate.
 */
interface MaxAggregate : ElasticsearchAggregate {
    /**
     * Returns wether this instance is a max_aggregate or not.
     */
    val isaMaxAggregate: Boolean
}
