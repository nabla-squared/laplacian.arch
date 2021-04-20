package laplacian.arch.backend.api.graphql

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.util.*

/**
 * An entity describing a custom_fetcher.
 */
interface CustomFetcher : GraphqlFieldFetcher {
    /**
     * Defines this custom_fetcher is async or not.
     */
    val async: Boolean
    /**
     * Returns wether this instance is a custom_fetcher or not.
     */
    val isaCustomFetcher: Boolean
}
