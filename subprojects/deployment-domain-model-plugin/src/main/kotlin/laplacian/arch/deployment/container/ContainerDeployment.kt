package laplacian.arch.deployment.container
import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.arch.deployment.Deployment

import laplacian.util.*

/**
 * An entity describing a container_deployment.
 */
interface ContainerDeployment : Deployment {
    /**
     * The instance_name of this container_deployment.
     */
    val instanceName: String
    /**
     * The tag of this container_deployment.
     */
    val tag: String
    /**
     * The container_registry of this container_deployment.
     */
    val containerRegistry: String
    /**
     * The container_image_name of this container_deployment.
     */
    val containerImageName: String
    /**
     * Defines this container_deployment is use_locally_built_image or not.
     */
    val useLocallyBuiltImage: Boolean
    /**
     * The environment_variables of this container_deployment.
     */
    val environmentVariables: List<EnvironmentVariableAssignment>
    /**
     * The data_files of this container_deployment.
     */
    val dataFiles: List<DataFile>
    /**
     * The container_image of this container_deployment.
     */
    val containerImage: ContainerImage
    /**
     * Returns wether this instance is a container_deployment or not.
     */
    val isaContainerDeployment: Boolean
}
