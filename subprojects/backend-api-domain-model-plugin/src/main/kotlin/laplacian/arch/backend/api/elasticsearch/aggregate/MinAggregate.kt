package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a min_aggregate.
 */
interface MinAggregate : ElasticsearchAggregate {
    /**
     * Returns wether this instance is a min_aggregate or not.
     */
    val isaMinAggregate: Boolean
}
