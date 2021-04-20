package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a date_range_aggregate.
 */
interface DateRangeAggregate : ElasticsearchAggregate {
    /**
     * The format of this date_range_aggregate.
     */
    val format: String?
    /**
     * The ranges of this date_range_aggregate.
     */
    val ranges: List<AggregateGroupRange>
    /**
     * Returns wether this instance is a date_range_aggregate or not.
     */
    val isaDateRangeAggregate: Boolean
}
