package laplacian.arch.backend.api.graphql
import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.cache.CachePolicy


import laplacian.util.*

/**
 * An entity describing a graphql_field_fetcher.
 */
interface GraphqlFieldFetcher {
    /**
     * The type of this graphql_field_fetcher.
     */
    val type: String
    /**
     * The description of this graphql_field_fetcher.
     */
    val description: String
    /**
     * Defines this graphql_field_fetcher is is_batch or not.
     */
    val isBatch: Boolean
    /**
     * The result_selector of this graphql_field_fetcher.
     */
    val resultSelector: String?
    /**
     * The result_mapper of this graphql_field_fetcher.
     */
    val resultMapper: String
    /**
     * The cache_policy_name of this graphql_field_fetcher.
     */
    val cachePolicyName: String?
    /**
     * The java_interface of this graphql_field_fetcher.
     */
    val javaInterface: String
    /**
     * The java_interface_name of this graphql_field_fetcher.
     */
    val javaInterfaceName: String
    /**
     * The graphql_field of this graphql_field_fetcher.
     */
    val graphqlField: GraphqlField
    /**
     * The graphql_field_arguments of this graphql_field_fetcher.
     */
    val graphqlFieldArguments: List<ApiCallArgument>
    /**
     * The graphql_type of this graphql_field_fetcher.
     */
    val graphqlType: GraphqlType
    /**
     * The cache_policy of this graphql_field_fetcher.
     */
    val cachePolicy: CachePolicy?
    /**
     * Returns wether this instance is a graphql_field_fetcher or not.
     */
    val isaGraphqlFieldFetcher: Boolean
}
