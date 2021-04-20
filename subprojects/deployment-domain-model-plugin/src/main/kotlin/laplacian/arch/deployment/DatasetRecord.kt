package laplacian.arch.deployment
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a dataset.
 */
data class DatasetRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Dataset, Record by _record {

    /**
     * The name of this dataset.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The tags of this dataset.
     */
    override val tags: List<String>
        get() = getOrThrow("tags") {
            emptyList<String>()
        }
    /**
     * The content of this dataset.
     */
    override val content: List<Any> by lazy {
        _record.getList<Map<String, Any?>>("content", emptyList())
    }
    /**
     * Returns wether this instance is a dataset or not.
     */
    override val isaDataset: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDatasets {
            return _context.get("datasets") as AllDatasets
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DatasetRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DatasetRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DatasetRecord(" +
            "name=$name" +
        ")"
    }
}
