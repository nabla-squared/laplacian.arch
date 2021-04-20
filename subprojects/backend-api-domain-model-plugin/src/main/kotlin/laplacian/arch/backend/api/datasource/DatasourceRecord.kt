package laplacian.arch.backend.api.datasource
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * A *DataSource* represents an interface through which a client application access to a data store.
This includes the following models.
- The entity that the datastore exposes to the client
- Statement issued by the client to the datastore
 */
data class DatasourceRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Datasource, Record by _record {

    /**
     * The name of this datasource.
     */
    override val name: String?
        by _record
    /**
     * The description of this datasource.
     */
    override val description: String
        get() = getOrThrow("description") {
            name
        }
    /**
     * The db_type of this datasource.
     */
    override val dbType: String
        get() = getOrThrow("dbType")
    /**
     * Defines this datasource is non_blocking or not.
     */
    override val nonBlocking: Boolean
        get() = getOrThrow("nonBlocking")
    /**
     * Returns wether this instance is a datasource or not.
     */
    override val isaDatasource: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDatasources {
            return _context.get("datasources") as AllDatasources
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            DatasourceRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DatasourceRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DatasourceRecord(" +
            "name=$name" +
        ")"
    }
}
