package laplacian.arch.deployment.component.postgres

import laplacian.arch.deployment.container.DbContainerDeployment

import laplacian.util.*

/**
 * An entity describing a postgres_container_deployment.
 */
interface PostgresContainerDeployment : DbContainerDeployment {
    /**
     * Returns wether this instance is a postgres_container_deployment or not.
     */
    val isaPostgresContainerDeployment: Boolean
}
