package laplacian.arch.deployment.component.mysql
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Environment
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.arch.deployment.container.DbContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a mysql_container_deployment.
 */
data class MysqlContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): DbContainerDeploymentRecord(__record, _context, environment), MysqlContainerDeployment {

    /**
     * The port of this mysql_container_deployment.
     */
    override val port: Int
        get() = getOrThrow("port") {
            3306
        }
    /**
     * The jdbc_driver_jar of this mysql_container_deployment.
     */
    override val jdbcDriverJar: String
        get() = getOrThrow("jdbcDriverJar") {
            "mysql:mysql-connector-java:8.0.23"
        }
    /**
     * The jdbc_connection_string of this mysql_container_deployment.
     */
    override val jdbcConnectionString: String
        get() = "jdbc:mysql://${instanceName}/${databaseName}"
    /**
     * The jdbc_driver_class_name of this mysql_container_deployment.
     */
    override val jdbcDriverClassName: String
        get() = getOrThrow("jdbcDriverClassName") {
            "com.mysql.jdbc.Driver"
        }
    /**
     * Returns wether this instance is a mysql_container_deployment or not.
     */
    override val isaMysqlContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            MysqlContainerDeploymentRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MysqlContainerDeploymentRecord) return false
        if (environment != other.environment) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = environment.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "MysqlContainerDeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
