package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_request_parameter.
 */
interface RestRequestParameter {
    /**
     * The name of this rest_request_parameter.
     */
    val name: String
    /**
     * The type of this rest_request_parameter.
     */
    val type: String
    /**
     * Defines this rest_request_parameter is multiple or not.
     */
    val multiple: Boolean
    /**
     * The value of this rest_request_parameter.
     */
    val value: String
    /**
     * Defines this rest_request_parameter is variable or not.
     */
    val variable: Boolean
    /**
     * Returns wether this instance is a rest_request_parameter or not.
     */
    val isaRestRequestParameter: Boolean
}
