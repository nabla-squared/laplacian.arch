package laplacian.arch.backend.api


import laplacian.util.*

/**
 * An entity describing a service_configuration.
 */
interface ServiceConfiguration {
    /**
     * The name of this service_configuration.
     */
    val name: String
    /**
     * The category of this service_configuration.
     */
    val category: String
    /**
     * The type of this service_configuration.
     */
    val type: String
    /**
     * The key of this service_configuration.
     */
    val key: String
    /**
     * The default_value of this service_configuration.
     */
    val defaultValue: String?
    /**
     * The environment_variable_name of this service_configuration.
     */
    val environmentVariableName: String
    /**
     * Returns wether this instance is a service_configuration or not.
     */
    val isaServiceConfiguration: Boolean
}
