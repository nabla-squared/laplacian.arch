package laplacian.arch.deployment.component.elasticsearch
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a initial_index_data.
 */
interface InitialIndexData {
    /**
     * The index_name of this initial_index_data.
     */
    val indexName: String
    /**
     * The index_model_name of this initial_index_data.
     */
    val indexModelName: String
    /**
     * The index_model of this initial_index_data.
     */
    val indexModel: Entity
    /**
     * Returns wether this instance is a initial_index_data or not.
     */
    val isaInitialIndexData: Boolean
}
