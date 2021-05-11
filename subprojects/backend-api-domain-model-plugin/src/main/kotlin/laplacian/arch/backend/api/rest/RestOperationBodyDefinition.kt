package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_operation_body_definition.
 */
interface RestOperationBodyDefinition {
    /**
     * The format of this rest_operation_body_definition.
     */
    val format: String
    /**
     * Defines this rest_operation_body_definition is multiple or not.
     */
    val multiple: Boolean
    /**
     * Defines this rest_operation_body_definition is optional or not.
     */
    val optional: Boolean
    /**
     * The schema of this rest_operation_body_definition.
     */
    val schema: RestOperationBodySchema
    /**
     * Returns wether this instance is a rest_operation_body_definition or not.
     */
    val isaRestOperationBodyDefinition: Boolean
}
