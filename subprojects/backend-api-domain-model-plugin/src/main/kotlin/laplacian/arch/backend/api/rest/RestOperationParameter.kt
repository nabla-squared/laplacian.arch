package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_operation_parameter.
 */
interface RestOperationParameter {
    /**
     * The name of this rest_operation_parameter.
     */
    val name: String
    /**
     * The description of this rest_operation_parameter.
     */
    val description: String
    /**
     * Defines this rest_operation_parameter is required or not.
     */
    val required: Boolean
    /**
     * The type of this rest_operation_parameter.
     */
    val type: String
    /**
     * Defines this rest_operation_parameter is multiple or not.
     */
    val multiple: Boolean
    /**
     * The type_in_java of this rest_operation_parameter.
     */
    val typeInJava: String
    /**
     * Returns wether this instance is a rest_operation_parameter or not.
     */
    val isaRestOperationParameter: Boolean
}
