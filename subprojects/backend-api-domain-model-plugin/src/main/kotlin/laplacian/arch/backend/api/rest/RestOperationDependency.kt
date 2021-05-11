package laplacian.arch.backend.api.rest
import laplacian.arch.backend.api.aggregate.Aggregate
import laplacian.arch.backend.api.aggregate.AggregateAccessMethod


import laplacian.util.*

/**
 * An entity describing a rest_operation_dependency.
 */
interface RestOperationDependency {
    /**
     * The type of this rest_operation_dependency.
     */
    val type: String
    /**
     * The aggregate_name of this rest_operation_dependency.
     */
    val aggregateName: String
    /**
     * The aggregate_namespace of this rest_operation_dependency.
     */
    val aggregateNamespace: String
    /**
     * The method_name of this rest_operation_dependency.
     */
    val methodName: String
    /**
     * The aggregate of this rest_operation_dependency.
     */
    val aggregate: Aggregate
    /**
     * The access_method of this rest_operation_dependency.
     */
    val accessMethod: AggregateAccessMethod
    /**
     * Returns wether this instance is a rest_operation_dependency or not.
     */
    val isaRestOperationDependency: Boolean
}
