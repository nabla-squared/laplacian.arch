package laplacian.arch.deployment.component.elasticsearch


import laplacian.util.*

/**
 * An entity describing a elasticsearch_client_configuration.
 */
interface ElasticsearchClientConfiguration {
    /**
     * The name of this elasticsearch_client_configuration.
     */
    val name: String
    /**
     * The port of this elasticsearch_client_configuration.
     */
    val port: Int
    /**
     * The endpoints of this elasticsearch_client_configuration.
     */
    val endpoints: List<String>
    /**
     * Returns wether this instance is a elasticsearch_client_configuration or not.
     */
    val isaElasticsearchClientConfiguration: Boolean
}
