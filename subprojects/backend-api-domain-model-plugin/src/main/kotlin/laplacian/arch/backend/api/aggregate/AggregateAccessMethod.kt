package laplacian.arch.backend.api.aggregate
import laplacian.arch.backend.api.ApiCallArgument
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a aggregate_access_method.
 */
interface AggregateAccessMethod {
    /**
     * The name of this aggregate_access_method.
     */
    val name: String
    /**
     * The type of this aggregate_access_method.
     */
    val type: String
    /**
     * Defines this aggregate_access_method is multiple or not.
     */
    val multiple: Boolean
    /**
     * Defines this aggregate_access_method is with_pagination or not.
     */
    val withPagination: Boolean
    /**
     * The record_model_name of this aggregate_access_method.
     */
    val recordModelName: String
    /**
     * The record_model_namespace of this aggregate_access_method.
     */
    val recordModelNamespace: String
    /**
     * The aggregate of this aggregate_access_method.
     */
    val aggregate: Aggregate
    /**
     * The arguments of this aggregate_access_method.
     */
    val arguments: List<ApiCallArgument>
    /**
     * The record_model of this aggregate_access_method.
     */
    val recordModel: Entity
    /**
     * Returns wether this instance is a aggregate_access_method or not.
     */
    val isaAggregateAccessMethod: Boolean
}
