package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.container.EnvironmentVariableAssignment

import laplacian.arch.deployment.container.DataFile

import laplacian.arch.deployment.component.container.ContainerImage
import laplacian.arch.deployment.component.container.ContainerImageRecord
import laplacian.arch.deployment.Environment
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.arch.deployment.DeploymentRecord
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchContainerDeploymentRecord
import laplacian.arch.deployment.component.springboot2_api_service.Springboot2ApiServiceContainerDeploymentRecord
import laplacian.arch.deployment.container.DbContainerDeploymentRecord
import laplacian.arch.deployment.component.mysql.MysqlContainerDeploymentRecord
import laplacian.arch.deployment.component.postgres.PostgresContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a container_deployment.
 */
open class ContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): DeploymentRecord(__record, _context, environment), ContainerDeployment {

    /**
     * The instance_name of this container_deployment.
     */
    override val instanceName: String
        get() = getOrThrow("instanceName") {
            component.name.lowerHyphenize()
        }
    /**
     * The tag of this container_deployment.
     */
    override val tag: String
        get() = getOrThrow("tag") {
            "latest"
        }
    /**
     * The container_registry of this container_deployment.
     */
    override val containerRegistry: String
        get() = getOrThrow("containerRegistry") {
            ""
        }
    /**
     * The container_image_name of this container_deployment.
     */
    override val containerImageName: String
        get() = "${containerRegistry}${if (containerRegistry.isNotBlank()) "/" else ""}${containerImage.baseName}:${tag}"
    /**
     * Defines this container_deployment is use_locally_built_image or not.
     */
    override val useLocallyBuiltImage: Boolean
        get() = getOrThrow("useLocallyBuiltImage") {
            true
        }
    /**
     * The environment_variables of this container_deployment.
     */
    override val environmentVariables: List<EnvironmentVariableAssignment> by lazy {
        EnvironmentVariableAssignmentRecord.from(_record.getList("environment_variables", emptyList()), _context, this)
    }
    /**
     * The data_files of this container_deployment.
     */
    override val dataFiles: List<DataFile> by lazy {
        DataFileRecord.from(_record.getList("data_files", emptyList()), _context)
    }
    /**
     * The container_image of this container_deployment.
     */
    override val containerImage: ContainerImage by lazy {
        component as ContainerImage
    }
    /**
     * Returns wether this instance is a container_deployment or not.
     */
    override val isaContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            ContainerDeploymentRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContainerDeploymentRecord) return false
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
        return "ContainerDeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
