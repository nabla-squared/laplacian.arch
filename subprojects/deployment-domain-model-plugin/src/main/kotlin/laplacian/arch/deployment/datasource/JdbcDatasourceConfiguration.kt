package laplacian.arch.deployment.datasource

import laplacian.arch.deployment.datasource.DatasourceConfiguration

import laplacian.util.*

/**
 * jdbc datasource setting with Hikari connection pool.

 */
interface JdbcDatasourceConfiguration : DatasourceConfiguration {
    /**
     * The jdbc_connection_string of this jdbc_datasource_configuration.
     */
    val jdbcConnectionString: String
    /**
     * The url of this jdbc_datasource_configuration.
     */
    val url: String
    /**
     * The username of this jdbc_datasource_configuration.
     */
    val username: String
    /**
     * The password of this jdbc_datasource_configuration.
     */
    val password: String
    /**
     * The database_name of this jdbc_datasource_configuration.
     */
    val databaseName: String
    /**
     * The driver_class_name of this jdbc_datasource_configuration.
     */
    val driverClassName: String
    /**
     * The slow_query_threshold_mills of this jdbc_datasource_configuration.
     */
    val slowQueryThresholdMills: Int?
    /**
     * The minimum_idle of this jdbc_datasource_configuration.
     */
    val minimumIdle: Int?
    /**
     * The maximum_pool_size of this jdbc_datasource_configuration.
     */
    val maximumPoolSize: Int?
    /**
     * The idle_timeout of this jdbc_datasource_configuration.
     */
    val idleTimeout: Int?
    /**
     * The max_lifetime of this jdbc_datasource_configuration.
     */
    val maxLifetime: Int?
    /**
     * The connection_timeout of this jdbc_datasource_configuration.
     */
    val connectionTimeout: Int?
    /**
     * Returns wether this instance is a jdbc_datasource_configuration or not.
     */
    val isaJdbcDatasourceConfiguration: Boolean
}
