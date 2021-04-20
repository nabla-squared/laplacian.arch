package laplacian.arch.deployment.container

import laplacian.arch.deployment.container.ContainerDeployment

import laplacian.util.*

/**
 * An entity describing a db_container_deployment.
 */
interface DbContainerDeployment : ContainerDeployment {
    /**
     * The username of this db_container_deployment.
     */
    val username: String
    /**
     * The password of this db_container_deployment.
     */
    val password: String?
    /**
     * The database_name of this db_container_deployment.
     */
    val databaseName: String
    /**
     * The port of this db_container_deployment.
     */
    val port: Int?
    /**
     * The gradle_version of this db_container_deployment.
     */
    val gradleVersion: String
    /**
     * The flyway_container_base_image of this db_container_deployment.
     */
    val flywayContainerBaseImage: String
    /**
     * The flyway_version of this db_container_deployment.
     */
    val flywayVersion: String
    /**
     * The jdbc_driver_jar of this db_container_deployment.
     */
    val jdbcDriverJar: String
    /**
     * The jdbc_driver_class_name of this db_container_deployment.
     */
    val jdbcDriverClassName: String
    /**
     * The jdbc_connection_string of this db_container_deployment.
     */
    val jdbcConnectionString: String
    /**
     * The initial_data of this db_container_deployment.
     */
    val initialData: List<InitialTableData>
    /**
     * Returns wether this instance is a db_container_deployment or not.
     */
    val isaDbContainerDeployment: Boolean
}
