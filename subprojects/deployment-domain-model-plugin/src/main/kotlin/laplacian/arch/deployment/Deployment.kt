package laplacian.arch.deployment
import laplacian.arch.deployment.component.Component


import laplacian.util.*

/**
 * An entity describing a deployment.
 */
interface Deployment {
    /**
     * The name of this deployment.
     */
    val name: String
    /**
     * The type of this deployment.
     */
    val type: String
    /**
     * The environment of this deployment.
     */
    val environment: Environment
    /**
     * The component of this deployment.
     */
    val component: Component
    /**
     * Returns wether this instance is a deployment or not.
     */
    val isaDeployment: Boolean
}
