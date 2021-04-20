package laplacian.arch.deployment.component
import com.github.jknack.handlebars.Context


import laplacian.arch.deployment.component.container.ContainerImageRecord
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchContainerImageRecord
import laplacian.arch.deployment.component.mysql.MysqlContainerImageRecord
import laplacian.arch.deployment.component.postgres.PostgresContainerImageRecord
import laplacian.arch.deployment.component.springboot2_api_service.Springboot2ApiServiceContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a component.
 */
open class ComponentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Component, Record by _record {

    /**
     * The name of this component.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The type of this component.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The tags of this component.
     */
    override val tags: List<String>
        get() = getOrThrow("tags") {
            emptyList<String>()
        }
    /**
     * Returns wether this instance is a component or not.
     */
    override val isaComponent: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllComponents {
            return _context.get("components") as AllComponents
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["type"]) {
                "container_image" -> ContainerImageRecord(record, _context)
                "elasticsearch_container_image" -> ElasticsearchContainerImageRecord(record, _context)
                "mysql_container_image" -> MysqlContainerImageRecord(record, _context)
                "postgres_container_image" -> PostgresContainerImageRecord(record, _context)
                "springboot2_api_service_container_image" -> Springboot2ApiServiceContainerImageRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [container_image, elasticsearch_container_image, mysql_container_image, postgres_container_image, springboot2_api_service_container_image]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComponentRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ComponentRecord(" +
            "name=$name" +
        ")"
    }
}
