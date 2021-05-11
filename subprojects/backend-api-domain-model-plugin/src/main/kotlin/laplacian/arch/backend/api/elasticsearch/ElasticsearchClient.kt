package laplacian.arch.backend.api.elasticsearch


import laplacian.util.*

/**
 * An entity describing a elasticsearch_client.
 */
interface ElasticsearchClient {
    /**
     * The name of this elasticsearch_client.
     */
    val name: String
    /**
     * Defines this elasticsearch_client is primary or not.
     */
    val primary: Boolean
    /**
     * Returns wether this instance is a elasticsearch_client or not.
     */
    val isaElasticsearchClient: Boolean
}
