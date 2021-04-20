package laplacian.arch.backend.api


import laplacian.util.*

/**
 * An entity describing a configuration_binding.
 */
interface ConfigurationBinding {
    /**
     * The name of this configuration_binding.
     */
    val name: String
    /**
     * The category of this configuration_binding.
     */
    val category: String
    /**
     * The variable_name of this configuration_binding.
     */
    val variableName: String
    /**
     * The definition of this configuration_binding.
     */
    val definition: ServiceConfiguration
    /**
     * Returns wether this instance is a configuration_binding or not.
     */
    val isaConfigurationBinding: Boolean
}
