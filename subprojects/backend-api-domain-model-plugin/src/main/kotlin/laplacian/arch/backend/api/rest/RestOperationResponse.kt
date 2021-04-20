package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_operation_response.
 */
interface RestOperationResponse {
    /**
     * The type of this rest_operation_response.
     */
    val type: String
    /**
     * Defines this rest_operation_response is optional or not.
     */
    val optional: Boolean
    /**
     * Defines this rest_operation_response is multiple or not.
     */
    val multiple: Boolean
    /**
     * The type_in_java of this rest_operation_response.
     */
    val typeInJava: String
    /**
     * Returns wether this instance is a rest_operation_response or not.
     */
    val isaRestOperationResponse: Boolean
}
