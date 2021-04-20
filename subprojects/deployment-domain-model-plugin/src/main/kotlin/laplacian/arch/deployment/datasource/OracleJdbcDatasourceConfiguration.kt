package laplacian.arch.deployment.datasource

import laplacian.arch.deployment.datasource.JdbcDatasourceConfiguration

import laplacian.util.*

/**
 * An entity describing a oracle_jdbc_datasource_configuration.
 */
interface OracleJdbcDatasourceConfiguration : JdbcDatasourceConfiguration {
    /**
     * Returns wether this instance is a oracle_jdbc_datasource_configuration or not.
     */
    val isaOracleJdbcDatasourceConfiguration: Boolean
}
