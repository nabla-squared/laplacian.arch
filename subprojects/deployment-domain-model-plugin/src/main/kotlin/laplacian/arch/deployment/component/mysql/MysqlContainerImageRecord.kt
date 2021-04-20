package laplacian.arch.deployment.component.mysql
import com.github.jknack.handlebars.Context

import laplacian.arch.deployment.component.container.ContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a mysql_container_image.
 */
data class MysqlContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerImageRecord(__record, _context), MysqlContainerImage {

    /**
     * The base_name of this mysql_container_image.
     */
    override val baseName: String
        get() = getOrThrow("baseName") {
            "mysql"
        }
    /**
     * Returns wether this instance is a mysql_container_image or not.
     */
    override val isaMysqlContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            MysqlContainerImageRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MysqlContainerImageRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "MysqlContainerImageRecord(" +
            "name=$name" +
        ")"
    }
}
