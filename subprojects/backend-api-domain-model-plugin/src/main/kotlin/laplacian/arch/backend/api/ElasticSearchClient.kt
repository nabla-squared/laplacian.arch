package laplacian.arch.backend.api


import laplacian.util.*

/**
 * An entity describing a elastic_search_client.
 */
interface ElasticSearchClient {
    /**
     * The name of this elastic_search_client.
     */
    val name: String
    /**
     * Defines this elastic_search_client is is_default or not.
     */
    val isDefault: Boolean
    /**
     * The configuration_category of this elastic_search_client.
     */
    val configurationCategory: String
    /**
     * The configuration_name_of_endpoints of this elastic_search_client.
     */
    val configurationNameOfEndpoints: String
    /**
     * The configuration_name_of_path_prefix of this elastic_search_client.
     */
    val configurationNameOfPathPrefix: String
    /**
     * The configuration_name_of_connect_timeout of this elastic_search_client.
     */
    val configurationNameOfConnectTimeout: String
    /**
     * The configuration_name_of_socket_timeout of this elastic_search_client.
     */
    val configurationNameOfSocketTimeout: String
    /**
     * The configuration_name_of_max_in_memory_size of this elastic_search_client.
     */
    val configurationNameOfMaxInMemorySize: String
    /**
     * The configurations of this elastic_search_client.
     */
    val configurations: List<ServiceConfiguration>
    /**
     * The endpoints of this elastic_search_client.
     */
    val endpoints: ServiceConfiguration
    /**
     * The path_prefix of this elastic_search_client.
     */
    val pathPrefix: ServiceConfiguration?
    /**
     * The connect_timeout of this elastic_search_client.
     */
    val connectTimeout: ServiceConfiguration?
    /**
     * The socket_timeout of this elastic_search_client.
     */
    val socketTimeout: ServiceConfiguration?
    /**
     * The max_in_memory_size of this elastic_search_client.
     */
    val maxInMemorySize: ServiceConfiguration?
    /**
     * Returns wether this instance is a elastic_search_client or not.
     */
    val isaElasticSearchClient: Boolean
}
