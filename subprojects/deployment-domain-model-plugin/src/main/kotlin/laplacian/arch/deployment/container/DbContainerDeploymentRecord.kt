package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.container.InitialTableData

import laplacian.arch.deployment.Environment
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.arch.deployment.container.ContainerDeploymentRecord
import laplacian.arch.deployment.component.mysql.MysqlContainerDeploymentRecord
import laplacian.arch.deployment.component.postgres.PostgresContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a db_container_deployment.
 */
open class DbContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerDeploymentRecord(__record, _context, environment), DbContainerDeployment {

    /**
     * The username of this db_container_deployment.
     */
    override val username: String
        get() = getOrThrow("username")
    /**
     * The password of this db_container_deployment.
     */
    override val password: String?
        by _record
    /**
     * The database_name of this db_container_deployment.
     */
    override val databaseName: String
        get() = getOrThrow("databaseName") {
            component.name.lowerHyphenize()
        }
    /**
     * The port of this db_container_deployment.
     */
    override val port: Int?
        by _record
    /**
     * The gradle_version of this db_container_deployment.
     */
    override val gradleVersion: String
        get() = getOrThrow("gradleVersion") {
            "6.6.1"
        }
    /**
     * The flyway_container_base_image of this db_container_deployment.
     */
    override val flywayContainerBaseImage: String
        get() = getOrThrow("flywayContainerBaseImage") {
            "adoptopenjdk:11-jdk-hotspot"
        }
    /**
     * The flyway_version of this db_container_deployment.
     */
    override val flywayVersion: String
        get() = getOrThrow("flywayVersion") {
            "7.5.1"
        }
    /**
     * The jdbc_driver_jar of this db_container_deployment.
     */
    override val jdbcDriverJar: String
        get() = getOrThrow("jdbcDriverJar")
    /**
     * The jdbc_driver_class_name of this db_container_deployment.
     */
    override val jdbcDriverClassName: String
        get() = getOrThrow("jdbcDriverClassName")
    /**
     * The jdbc_connection_string of this db_container_deployment.
     */
    override val jdbcConnectionString: String
        get() = getOrThrow("jdbcConnectionString")
    /**
     * Defines this db_container_deployment is enable_db_migration or not.
     */
    override val enableDbMigration: Boolean
        get() = getOrThrow("enableDbMigration") {
            initialData.isNotEmpty()
        }
    /**
     * Defines this db_container_deployment is generates_ddl_migration or not.
     */
    override val generatesDdlMigration: Boolean
        get() = getOrThrow("generatesDdlMigration") {
            enableDbMigration
        }
    /**
     * The generated_migration_base_version of this db_container_deployment.
     */
    override val generatedMigrationBaseVersion: String
        get() = getOrThrow("generatedMigrationBaseVersion") {
            "1.0"
        }
    /**
     * The initial_data of this db_container_deployment.
     */
    override val initialData: List<InitialTableData> by lazy {
        InitialTableDataRecord.from(_record.getList("initial_data", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a db_container_deployment or not.
     */
    override val isaDbContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            DbContainerDeploymentRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DbContainerDeploymentRecord) return false
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
        return "DbContainerDeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
