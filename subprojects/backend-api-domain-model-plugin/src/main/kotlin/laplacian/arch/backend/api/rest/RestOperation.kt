package laplacian.arch.backend.api.rest


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
     * Defines this rest_operation is with_pagination or not.
     */
    val withPagination: Boolean
    /**
     * The rest_resource of this rest_operation.
     */
    val restResource: RestResource
    /**
     * The path_parameters of this rest_operation.
     */
    val pathParameters: List<RestOperationParameter>
    /**
     * The query_parameters of this rest_operation.
     */
    val queryParameters: List<RestOperationParameter>
    /**
     * The http_headers of this rest_operation.
     */
    val httpHeaders: List<RestOperationParameter>
    /**
     * The request_body of this rest_operation.
     */
    val requestBody: RestOperationBodyDefinition?
    /**
     * The response_body of this rest_operation.
     */
    val responseBody: RestOperationBodyDefinition?
    /**
     * The dependencies of this rest_operation.
     */
    val dependencies: List<RestOperationDependency>
    /**
     * The usage_examples of this rest_operation.
     */
    val usageExamples: List<RestApiUsageExample>
    /**
     * Returns wether this instance is a rest_operation or not.
     */
    val isaRestOperation: Boolean
}
