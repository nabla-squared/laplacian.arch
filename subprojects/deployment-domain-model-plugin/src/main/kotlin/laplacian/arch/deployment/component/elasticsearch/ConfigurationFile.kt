package laplacian.arch.deployment.component.elasticsearch


import laplacian.util.*

/**
 * An entity describing a configuration_file.
 */
interface ConfigurationFile {
    /**
     * The path of this configuration_file.
     */
    val path: String
    /**
     * The content of this configuration_file.
     */
    val content: String
    /**
     * Returns wether this instance is a configuration_file or not.
     */
    val isaConfigurationFile: Boolean
}
