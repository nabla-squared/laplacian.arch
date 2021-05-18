package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_api_usage_example.
 */
interface RestApiUsageExample {
    /**
     * The rest_resource_name of this rest_api_usage_example.
     */
    val restResourceName: String
    /**
     * The namespace of this rest_api_usage_example.
     */
    val namespace: String
    /**
     * The operation_name of this rest_api_usage_example.
     */
    val operationName: String
    /**
     * The tags of this rest_api_usage_example.
     */
    val tags: List<String>
    /**
     * The usage of this rest_api_usage_example.
     */
    val usage: String
    /**
     * The curl of this rest_api_usage_example.
     */
    val curl: String
    /**
     * The queryParameters of this rest_api_usage_example.
     */
    val queryParameters: String
    /**
     * The request_body_json of this rest_api_usage_example.
     */
    val requestBodyJson: String
    /**
     * The status_code of this rest_api_usage_example.
     */
    val statusCode: Int
    /**
     * The response_body_json of this rest_api_usage_example.
     */
    val responseBodyJson: String
    /**
     * The rest_resource of this rest_api_usage_example.
     */
    val restResource: RestResource
    /**
     * The operation of this rest_api_usage_example.
     */
    val operation: RestOperation
    /**
     * Returns wether this instance is a rest_api_usage_example or not.
     */
    val isaRestApiUsageExample: Boolean
}
