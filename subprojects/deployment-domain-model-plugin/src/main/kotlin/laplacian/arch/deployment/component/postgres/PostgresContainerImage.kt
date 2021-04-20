package laplacian.arch.deployment.component.postgres

import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.util.*

/**
 * An entity describing a postgres_container_image.
 */
interface PostgresContainerImage : ContainerImage {
    /**
     * Returns wether this instance is a postgres_container_image or not.
     */
    val isaPostgresContainerImage: Boolean
}
