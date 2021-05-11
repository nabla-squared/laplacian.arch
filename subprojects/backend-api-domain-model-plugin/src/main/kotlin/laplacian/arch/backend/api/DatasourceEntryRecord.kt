package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource
import laplacian.arch.backend.api.datasource.DatasourceRecord



import laplacian.generate.util.*
/**
 * An entity describing a datasource_entry.
 */
data class DatasourceEntryRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DatasourceEntry, Record by _record {

    /**
     * The name of this datasource_entry.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * Defines this datasource_entry is primary or not.
     */
    override val primary: Boolean
        get() = getOrThrow("primary") {
            false
        }
    /**
     * The datasource of this datasource_entry.
     */
    override val datasource: Datasource by lazy {
        DatasourceRecord.from(_context).find {
            it.name == name
        } ?: throw IllegalStateException(
            "There is no datasource which meets the following condition(s): "
            + "DatasourceEntry.name == datasource.name (=$name) "
            + "Possible values are: " + DatasourceRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a datasource_entry or not.
     */
    override val isaDatasourceEntry: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDatasourceEntries {
            return _context.get("datasource_entries") as AllDatasourceEntries
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DatasourceEntryRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DatasourceEntryRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DatasourceEntryRecord(" +
            "name=$name" +
        ")"
    }
}
