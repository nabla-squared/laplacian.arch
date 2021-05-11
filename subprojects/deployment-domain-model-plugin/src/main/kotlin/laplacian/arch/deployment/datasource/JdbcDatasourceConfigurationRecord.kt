package laplacian.arch.deployment.datasource
import com.github.jknack.handlebars.Context

import laplacian.arch.deployment.datasource.DatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.MysqlJdbcDatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.OracleJdbcDatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.PostgresJdbcDatasourceConfigurationRecord

import laplacian.generate.util.*
/**
 * jdbc datasource setting with Hikari connection pool.
 */
open class JdbcDatasourceConfigurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DatasourceConfigurationRecord(__record, _context), JdbcDatasourceConfiguration {

    /**
     * The jdbc_connection_string of this jdbc_datasource_configuration.
     */
    override val jdbcConnectionString: String
        get() = getOrThrow("jdbcConnectionString")
    /**
     * The url of this jdbc_datasource_configuration.
     */
    override val url: String
        get() = getOrThrow("url") {
            name.lowerHyphenize()
        }
    /**
     * The username of this jdbc_datasource_configuration.
     */
    override val username: String
        get() = getOrThrow("username")
    /**
     * The password of this jdbc_datasource_configuration.
     */
    override val password: String
        get() = getOrThrow("password")
    /**
     * The database_name of this jdbc_datasource_configuration.
     */
    override val databaseName: String
        get() = getOrThrow("databaseName") {
            name.lowerHyphenize()
        }
    /**
     * The driver_class_name of this jdbc_datasource_configuration.
     */
    override val driverClassName: String
        get() = getOrThrow("driverClassName")
    /**
     * The slow_query_threshold_mills of this jdbc_datasource_configuration.
     */
    override val slowQueryThresholdMills: Int?
        by _record
    /**
     * The minimum_idle of this jdbc_datasource_configuration.
     */
    override val minimumIdle: Int?
        by _record
    /**
     * The maximum_pool_size of this jdbc_datasource_configuration.
     */
    override val maximumPoolSize: Int?
        by _record
    /**
     * The idle_timeout of this jdbc_datasource_configuration.
     */
    override val idleTimeout: Int?
        by _record
    /**
     * The max_lifetime of this jdbc_datasource_configuration.
     */
    override val maxLifetime: Int?
        by _record
    /**
     * The connection_timeout of this jdbc_datasource_configuration.
     */
    override val connectionTimeout: Int?
        by _record
    /**
     * Returns wether this instance is a jdbc_datasource_configuration or not.
     */
    override val isaJdbcDatasourceConfiguration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            JdbcDatasourceConfigurationRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JdbcDatasourceConfigurationRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "JdbcDatasourceConfigurationRecord(" +
            "name=$name" +
        ")"
    }
}
