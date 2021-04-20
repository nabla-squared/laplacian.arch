package laplacian.arch.deployment.component.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.component.container.EnvironmentVariableDefinition


import laplacian.arch.deployment.component.ComponentRecord
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchContainerImageRecord
import laplacian.arch.deployment.component.mysql.MysqlContainerImageRecord
import laplacian.arch.deployment.component.postgres.PostgresContainerImageRecord
import laplacian.arch.deployment.component.springboot2_api_service.Springboot2ApiServiceContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a container_image.
 */
open class ContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ComponentRecord(__record, _context), ContainerImage {

    /**
     * The base_name of this container_image.
     */
    override val baseName: String
        get() = getOrThrow("baseName") {
            name.lowerHyphenize()
        }
    /**
     * Defines this container_image is custom_built or not.
     */
    override val customBuilt: Boolean
        get() = getOrThrow("customBuilt") {
            false
        }
    /**
     * The environment_variables of this container_image.
     */
    override val environmentVariables: List<EnvironmentVariableDefinition> by lazy {
        EnvironmentVariableDefinitionRecord.from(_record.getList("environment_variables", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a container_image or not.
     */
    override val isaContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ContainerImageRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContainerImageRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ContainerImageRecord(" +
            "name=$name" +
        ")"
    }
}
