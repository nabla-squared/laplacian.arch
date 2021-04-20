package laplacian.arch.deployment
import laplacian.arch.deployment.component.Component
import laplacian.arch.deployment.container.ContainerDeployment
import laplacian.arch.deployment.component.container.ContainerImage


import laplacian.util.*

/**
 * An entity describing a environment.
 */
interface Environment {
    /**
     * The name of this environment.
     */
    val name: String
    /**
     * The tier of this environment.
     */
    val tier: String
    /**
     * Defines this environment is uses_locally_built_container_images or not.
     */
    val usesLocallyBuiltContainerImages: Boolean
    /**
     * Defines this environment is uses_gcp or not.
     */
    val usesGcp: Boolean
    /**
     * The deployments of this environment.
     */
    val deployments: List<Deployment>
    /**
     * The components of this environment.
     */
    val components: List<Component>
    /**
     * The container_deployments of this environment.
     */
    val containerDeployments: List<ContainerDeployment>
    /**
     * The container_images of this environment.
     */
    val containerImages: List<ContainerImage>
    /**
     * Returns wether this instance is a environment or not.
     */
    val isaEnvironment: Boolean
}
