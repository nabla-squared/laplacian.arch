package laplacian.arch.backend.api.aggregate


import laplacian.util.*

/**
 * An entity describing a aggregate_entry.
 */
interface AggregateEntry {
    /**
     * The name of this aggregate_entry.
     */
    val name: String
    /**
     * The namespace of this aggregate_entry.
     */
    val namespace: String
    /**
     * The aggregate of this aggregate_entry.
     */
    val aggregate: Aggregate
    /**
     * Returns wether this instance is a aggregate_entry or not.
     */
    val isaAggregateEntry: Boolean
}
