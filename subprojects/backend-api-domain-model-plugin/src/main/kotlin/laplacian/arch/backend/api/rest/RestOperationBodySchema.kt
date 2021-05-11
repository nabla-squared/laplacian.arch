package laplacian.arch.backend.api.rest
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a rest_operation_body_schema.
 */
interface RestOperationBodySchema {
    /**
     * The name of this rest_operation_body_schema.
     */
    val name: String
    /**
     * The namespace of this rest_operation_body_schema.
     */
    val namespace: String
    /**
     * The model of this rest_operation_body_schema.
     */
    val model: Entity
    /**
     * Returns wether this instance is a rest_operation_body_schema or not.
     */
    val isaRestOperationBodySchema: Boolean
}
