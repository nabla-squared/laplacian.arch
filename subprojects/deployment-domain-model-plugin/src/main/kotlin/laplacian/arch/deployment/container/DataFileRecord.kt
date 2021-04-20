package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Dataset
import laplacian.arch.deployment.DatasetRecord



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
     * The filename of this data_file.
     */
    override val filename: String
        get() = getOrThrow("filename")
    /**
     * The dir of this data_file.
     */
    override val dir: String
        get() = getOrThrow("dir") {
            "data"
        }
    /**
     * The dataset_name of this data_file.
     */
    override val datasetName: String
        get() = getOrThrow("datasetName")
    /**
     * The dataset of this data_file.
     */
    override val dataset: Dataset by lazy {
        DatasetRecord.from(_context).find {
            it.name == datasetName
        } ?: throw IllegalStateException(
            "There is no dataset which meets the following condition(s): "
            + "DataFile.dataset_name == dataset.name (=$datasetName) "
            + "Possible values are: " + DatasetRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
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
        if (filename != other.filename) return false
        return true
    }

    override fun hashCode(): Int {
        var result = filename.hashCode()
        return result
    }

    override fun toString(): String {
        return "DataFileRecord(" +
            "filename=$filename" +
        ")"
    }
}
