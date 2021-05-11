package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.component.elasticsearch.InitialIndexData

import laplacian.arch.deployment.Environment
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.arch.deployment.container.ContainerDeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_container_deployment.
 */
data class ElasticsearchContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerDeploymentRecord(__record, _context, environment), ElasticsearchContainerDeployment {

    /**
     * The port of this elasticsearch_container_deployment.
     */
    override val port: Int
        get() = getOrThrow("port") {
            9200
        }
    /**
     * The tag of this elasticsearch_container_deployment.
     */
    override val tag: String
        get() = getOrThrow("tag") {
            "7.12.1"
        }
    /**
     * The initial_data of this elasticsearch_container_deployment.
     */
    override val initialData: List<InitialIndexData> by lazy {
        InitialIndexDataRecord.from(_record.getList("initial_data", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_container_deployment or not.
     */
    override val isaElasticsearchContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            ElasticsearchContainerDeploymentRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchContainerDeploymentRecord) return false
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
        return "ElasticsearchContainerDeploymentRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
