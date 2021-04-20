package laplacian.arch.backend.api.data_file
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a data_file.
 */
data class DataFileRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DataFile, Record by _record {

    /**
     * The name of this data_file.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this data_file.
     */
    override val description: String
        get() = getOrThrow("description") {
            "Data file of ${name} in ${format}"
        }
    /**
     * The format of this data_file.
     */
    override val format: String
        get() = getOrThrow("format") {
            "json"
        }
    /**
     * The default_path of this data_file.
     */
    override val defaultPath: String
        get() = getOrThrow("defaultPath") {
            "./data/${name.lowerHyphenize()}.${format}"
        }
    /**
     * Returns wether this instance is a data_file or not.
     */
    override val isaDataFile: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDataFiles {
            return _context.get("data_files") as AllDataFiles
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DataFileRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DataFileRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DataFileRecord(" +
            "name=$name" +
        ")"
    }
}
