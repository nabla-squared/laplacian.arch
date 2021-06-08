package laplacian.arch.deployment
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Environment

import laplacian.arch.deployment.component.Component
import laplacian.arch.deployment.component.ComponentRecord


import laplacian.arch.deployment.container.ContainerDeploymentRecord
import laplacian.arch.deployment.ContainerOnGceInstanceRecord
import laplacian.arch.deployment.ContainerOnGcpCloudrunRecord
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchContainerDeploymentRecord
import laplacian.arch.deployment.component.springboot2_api_service.Springboot2ApiServiceContainerDeploymentRecord
import laplacian.arch.deployment.container.DbContainerDeploymentRecord
import laplacian.arch.deployment.component.mysql.MysqlContainerDeploymentRecord
import laplacian.arch.deployment.component.postgres.PostgresContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a deployment.
 */
open class DeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): Deployment, Record by _record {

    /**
     * The name of this deployment.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The component_name of this deployment.
     */
    override val componentName: String
        get() = getOrThrow("componentName") {
            name
        }
    /**
     * The type of this deployment.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The component of this deployment.
     */
    override val component: Component by lazy {
        ComponentRecord.from(_context).find {
            it.name == componentName
        } ?: throw IllegalStateException(
            "There is no component which meets the following condition(s): "
            + "Deployment.component_name == component.name (=$componentName) "
            + "Possible values are: " + ComponentRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a deployment or not.
     */
    override val isaDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            when (val type = record["type"]) {
                "container_deployment" -> ContainerDeploymentRecord(record, _context, environment = environment)
                "container_on_gce_instance" -> ContainerOnGceInstanceRecord(record, _context, environment = environment)
                "container_on_gcp_cloudrun" -> ContainerOnGcpCloudrunRecord(record, _context, environment = environment)
                "elasticsearch_container_deployment" -> ElasticsearchContainerDeploymentRecord(record, _context, environment = environment)
                "springboot2_api_service_container_deployment" -> Springboot2ApiServiceContainerDeploymentRecord(record, _context, environment = environment)
                "db_container_deployment" -> DbContainerDeploymentRecord(record, _context, environment = environment)
                "mysql_container_deployment" -> MysqlContainerDeploymentRecord(record, _context, environment = environment)
                "postgres_container_deployment" -> PostgresContainerDeploymentRecord(record, _context, environment = environment)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [container_deployment, container_on_gce_instance, container_on_gcp_cloudrun, elasticsearch_container_deployment, springboot2_api_service_container_deployment, db_container_deployment, mysql_container_deployment, postgres_container_deployment]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DeploymentRecord) return false
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
        return "DeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
