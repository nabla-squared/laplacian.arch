package laplacian.arch.deployment.datasource

import laplacian.arch.deployment.datasource.JdbcDatasourceConfiguration

import laplacian.util.*

/**
 * An entity describing a postgres_jdbc_datasource_configuration.
 */
interface PostgresJdbcDatasourceConfiguration : JdbcDatasourceConfiguration {
    /**
     * Returns wether this instance is a postgres_jdbc_datasource_configuration or not.
     */
    val isaPostgresJdbcDatasourceConfiguration: Boolean
}
