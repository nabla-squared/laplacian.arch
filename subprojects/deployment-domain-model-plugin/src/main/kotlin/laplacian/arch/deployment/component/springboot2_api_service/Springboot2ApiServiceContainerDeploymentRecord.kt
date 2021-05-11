package laplacian.arch.deployment.component.springboot2_api_service
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.datasource.DatasourceConfiguration
import laplacian.arch.deployment.datasource.DatasourceConfigurationRecord
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchClientConfiguration
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchClientConfigurationRecord
import laplacian.arch.deployment.Environment
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.arch.deployment.container.ContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a springboot2_api_service_container_deployment.
 */
data class Springboot2ApiServiceContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerDeploymentRecord(__record, _context, environment), Springboot2ApiServiceContainerDeployment {

    /**
     * The http_port of this springboot2_api_service_container_deployment.
     */
    override val httpPort: Int
        get() = getOrThrow("httpPort") {
            8080
        }
    /**
     * Defines this springboot2_api_service_container_deployment is enable_jmx or not.
     */
    override val enableJmx: Boolean
        get() = getOrThrow("enableJmx") {
            true
        }
    /**
     * The jmx_port of this springboot2_api_service_container_deployment.
     */
    override val jmxPort: Int
        get() = getOrThrow("jmxPort") {
            9010
        }
    /**
     * Defines this springboot2_api_service_container_deployment is enable_debug or not.
     */
    override val enableDebug: Boolean
        get() = getOrThrow("enableDebug") {
            false
        }
    /**
     * The debug_port of this springboot2_api_service_container_deployment.
     */
    override val debugPort: Int
        get() = getOrThrow("debugPort") {
            5005
        }
    /**
     * The datasources of this springboot2_api_service_container_deployment.
     */
    override val datasources: List<DatasourceConfiguration> by lazy {
        DatasourceConfigurationRecord.from(_record.getList("datasources", emptyList()), _context)
    }
    /**
     * The elasticsearch_clients of this springboot2_api_service_container_deployment.
     */
    override val elasticsearchClients: List<ElasticsearchClientConfiguration> by lazy {
        ElasticsearchClientConfigurationRecord.from(_record.getList("elasticsearch_clients", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a springboot2_api_service_container_deployment or not.
     */
    override val isaSpringboot2ApiServiceContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            Springboot2ApiServiceContainerDeploymentRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Springboot2ApiServiceContainerDeploymentRecord) return false
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
        return "Springboot2ApiServiceContainerDeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
