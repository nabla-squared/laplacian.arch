package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_operation_response_mapping.
 */
interface RestOperationResponseMapping {
    /**
     * The from of this rest_operation_response_mapping.
     */
    val from: String?
    /**
     * The to of this rest_operation_response_mapping.
     */
    val to: String?
    /**
     * Returns wether this instance is a rest_operation_response_mapping or not.
     */
    val isaRestOperationResponseMapping: Boolean
}
