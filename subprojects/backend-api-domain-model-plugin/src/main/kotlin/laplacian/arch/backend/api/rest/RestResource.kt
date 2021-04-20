package laplacian.arch.backend.api.rest
import laplacian.arch.backend.api.ConfigurationBinding


import laplacian.util.*

/**
 * An entity describing a rest_resource.
 */
interface RestResource {
    /**
     * The name of this rest_resource.
     */
    val name: String
    /**
     * The description of this rest_resource.
     */
    val description: String
    /**
     * The resource_model_name of this rest_resource.
     */
    val resourceModelName: String?
    /**
     * The base_url of this rest_resource.
     */
    val baseUrl: String
    /**
     * Defines this rest_resource is enable_automatic_cookie_handling or not.
     */
    val enableAutomaticCookieHandling: Boolean
    /**
     * The operations of this rest_resource.
     */
    val operations: List<RestOperation>
    /**
     * The configurations of this rest_resource.
     */
    val configurations: List<ConfigurationBinding>
    /**
     * Returns wether this instance is a rest_resource or not.
     */
    val isaRestResource: Boolean
}