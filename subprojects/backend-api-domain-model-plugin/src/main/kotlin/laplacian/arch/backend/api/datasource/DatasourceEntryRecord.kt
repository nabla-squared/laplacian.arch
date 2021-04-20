package laplacian.arch.backend.api.datasource
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource




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
}
