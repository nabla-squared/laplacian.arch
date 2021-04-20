package laplacian.arch.backend.api.rest

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.util.*

/**
 * An entity describing a rest_api_fetcher.
 */
interface RestApiFetcher : GraphqlFieldFetcher {
    /**
     * The rest_resource_name of this rest_api_fetcher.
     */
    val restResourceName: String
    /**
     * The rest_operation_name of this rest_api_fetcher.
     */
    val restOperationName: String
    /**
     * The rest_resource of this rest_api_fetcher.
     */
    val restResource: RestResource
    /**
     * The rest_operation of this rest_api_fetcher.
     */
    val restOperation: RestOperation
    /**
     * The argument_assignments of this rest_api_fetcher.
     */
    val argumentAssignments: List<ArgumentAssignment>
    /**
     * Returns wether this instance is a rest_api_fetcher or not.
     */
    val isaRestApiFetcher: Boolean
}
