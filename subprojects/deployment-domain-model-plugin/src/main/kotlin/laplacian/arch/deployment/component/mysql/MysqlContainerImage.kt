package laplacian.arch.deployment.component.mysql

import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.util.*

/**
 * An entity describing a mysql_container_image.
 */
interface MysqlContainerImage : ContainerImage {
    /**
     * Returns wether this instance is a mysql_container_image or not.
     */
    val isaMysqlContainerImage: Boolean
}
