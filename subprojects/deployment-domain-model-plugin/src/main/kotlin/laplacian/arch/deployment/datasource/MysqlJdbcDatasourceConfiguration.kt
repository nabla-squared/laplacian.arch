package laplacian.arch.deployment.datasource

import laplacian.arch.deployment.datasource.JdbcDatasourceConfiguration

import laplacian.util.*

/**
 * An entity describing a mysql_jdbc_datasource_configuration.
 */
interface MysqlJdbcDatasourceConfiguration : JdbcDatasourceConfiguration {
    /**
     * Returns wether this instance is a mysql_jdbc_datasource_configuration or not.
     */
    val isaMysqlJdbcDatasourceConfiguration: Boolean
}
