package laplacian.arch.backend.api.rest
import laplacian.arch.backend.api.ApiCallArgument


import laplacian.util.*

/**
 * An entity describing a rest_operation.
 */
interface RestOperation {
    /**
     * The method of this rest_operation.
     */
    val method: String
    /**
     * The path of this rest_operation.
     */
    val path: String
    /**
     * The name of this rest_operation.
     */
    val name: String
    /**
     * The description of this rest_operation.
     */
    val description: String
    /**
     * The arguments of this rest_operation.
     */
    val arguments: List<ApiCallArgument>
    /**
     * The path_parameters of this rest_operation.
     */
    val pathParameters: List<RestRequestParameter>
    /**
     * The query_parameters of this rest_operation.
     */
    val queryParameters: List<RestRequestParameter>
    /**
     * The http_headers of this rest_operation.
     */
    val httpHeaders: List<RestRequestParameter>
    /**
     * The rest_resource of this rest_operation.
     */
    val restResource: RestResource
    /**
     * The response of this rest_operation.
     */
    val response: RestOperationResponse
    /**
     * Returns wether this instance is a rest_operation or not.
     */
    val isaRestOperation: Boolean
}
