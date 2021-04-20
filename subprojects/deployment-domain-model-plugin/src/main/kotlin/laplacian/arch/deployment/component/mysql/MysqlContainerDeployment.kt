package laplacian.arch.deployment.component.mysql

import laplacian.arch.deployment.container.DbContainerDeployment

import laplacian.util.*

/**
 * An entity describing a mysql_container_deployment.
 */
interface MysqlContainerDeployment : DbContainerDeployment {
    /**
     * Returns wether this instance is a mysql_container_deployment or not.
     */
    val isaMysqlContainerDeployment: Boolean
}
