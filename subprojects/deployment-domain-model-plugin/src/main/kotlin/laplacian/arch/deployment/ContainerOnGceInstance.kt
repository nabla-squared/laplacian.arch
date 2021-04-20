package laplacian.arch.deployment

import laplacian.arch.deployment.Deployment

import laplacian.util.*

/**
 * An entity describing a container_on_gce_instance.
 */
interface ContainerOnGceInstance : Deployment {
    /**
     * The machine_type of this container_on_gce_instance.
     */
    val machineType: String
    /**
     * Returns wether this instance is a container_on_gce_instance or not.
     */
    val isaContainerOnGceInstance: Boolean
}
