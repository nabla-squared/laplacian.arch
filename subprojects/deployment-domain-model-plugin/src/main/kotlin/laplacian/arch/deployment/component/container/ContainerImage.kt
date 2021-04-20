package laplacian.arch.deployment.component.container

import laplacian.arch.deployment.component.Component

import laplacian.util.*

/**
 * An entity describing a container_image.
 */
interface ContainerImage : Component {
    /**
     * The base_name of this container_image.
     */
    val baseName: String
    /**
     * Defines this container_image is custom_built or not.
     */
    val customBuilt: Boolean
    /**
     * The environment_variables of this container_image.
     */
    val environmentVariables: List<EnvironmentVariableDefinition>
    /**
     * Returns wether this instance is a container_image or not.
     */
    val isaContainerImage: Boolean
}
