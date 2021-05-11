package laplacian.arch.deployment.component.elasticsearch

import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.util.*

/**
 * An entity describing a elasticsearch_container_image.
 */
interface ElasticsearchContainerImage : ContainerImage {
    /**
     * The plugins of this elasticsearch_container_image.
     */
    val plugins: List<String>
    /**
     * The configuration_file_dir_path of this elasticsearch_container_image.
     */
    val configurationFileDirPath: String
    /**
     * Defines this elasticsearch_container_image is uses_custom_image or not.
     */
    val usesCustomImage: Boolean
    /**
     * The configuration_files of this elasticsearch_container_image.
     */
    val configurationFiles: List<ConfigurationFile>
    /**
     * Returns wether this instance is a elasticsearch_container_image or not.
     */
    val isaElasticsearchContainerImage: Boolean
}
