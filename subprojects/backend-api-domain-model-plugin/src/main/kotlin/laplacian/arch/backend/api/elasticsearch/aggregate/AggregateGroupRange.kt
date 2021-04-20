package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a aggregate_group_range.
 */
interface AggregateGroupRange {
    /**
     * The key of this aggregate_group_range.
     */
    val key: String
    /**
     * The from of this aggregate_group_range.
     */
    val from: String?
    /**
     * The to of this aggregate_group_range.
     */
    val to: String?
    /**
     * Returns wether this instance is a aggregate_group_range or not.
     */
    val isaAggregateGroupRange: Boolean
}
