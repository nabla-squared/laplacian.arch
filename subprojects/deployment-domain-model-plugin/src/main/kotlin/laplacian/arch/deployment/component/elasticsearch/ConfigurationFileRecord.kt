package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a configuration_file.
 */
data class ConfigurationFileRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ConfigurationFile, Record by _record {

    /**
     * The path of this configuration_file.
     */
    override val path: String
        get() = getOrThrow("path")
    /**
     * The content of this configuration_file.
     */
    override val content: String
        get() = getOrThrow("content") {
            ""
        }
    /**
     * Returns wether this instance is a configuration_file or not.
     */
    override val isaConfigurationFile: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllConfigurationFiles {
            return _context.get("configuration_files") as AllConfigurationFiles
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ConfigurationFileRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ConfigurationFileRecord) return false
        if (path != other.path) return false
        return true
    }

    override fun hashCode(): Int {
        var result = path.hashCode()
        return result
    }

    override fun toString(): String {
        return "ConfigurationFileRecord(" +
            "path=$path" +
        ")"
    }
}
