package laplacian.arch.deployment.component.postgres
import com.github.jknack.handlebars.Context

import laplacian.arch.deployment.component.container.ContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a postgres_container_image.
 */
data class PostgresContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerImageRecord(__record, _context), PostgresContainerImage {

    /**
     * The base_name of this postgres_container_image.
     */
    override val baseName: String
        get() = getOrThrow("baseName") {
            "postgres"
        }
    /**
     * Returns wether this instance is a postgres_container_image or not.
     */
    override val isaPostgresContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            PostgresContainerImageRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PostgresContainerImageRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "PostgresContainerImageRecord(" +
            "name=$name" +
        ")"
    }
}
