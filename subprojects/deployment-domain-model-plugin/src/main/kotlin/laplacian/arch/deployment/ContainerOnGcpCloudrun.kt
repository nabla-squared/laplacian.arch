package laplacian.arch.deployment

import laplacian.arch.deployment.Deployment

import laplacian.util.*

/**
 * An entity describing a container_on_gcp_cloudrun.
 */
interface ContainerOnGcpCloudrun : Deployment {
    /**
     * Returns wether this instance is a container_on_gcp_cloudrun or not.
     */
    val isaContainerOnGcpCloudrun: Boolean
}
