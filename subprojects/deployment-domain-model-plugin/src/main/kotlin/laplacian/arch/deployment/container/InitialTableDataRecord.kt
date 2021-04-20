package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Dataset
import laplacian.arch.deployment.DatasetRecord
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord



import laplacian.generate.util.*
/**
 * An entity describing a initial_table_data.
 */
data class InitialTableDataRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): InitialTableData, Record by _record {

    /**
     * The table_name of this initial_table_data.
     */
    override val tableName: String
        get() = getOrThrow("tableName") {
            tableModelName
        }
    /**
     * The table_model_name of this initial_table_data.
     */
    override val tableModelName: String
        get() = getOrThrow("tableModelName") {
            tableName!!.lowerUnderscorize()
        }
    /**
     * The schema_name of this initial_table_data.
     */
    override val schemaName: String?
        by _record
    /**
     * The dataset_name of this initial_table_data.
     */
    override val datasetName: String
        get() = getOrThrow("datasetName")
    /**
     * The dataset of this initial_table_data.
     */
    override val dataset: Dataset by lazy {
        DatasetRecord.from(_context).find {
            it.name == datasetName
        } ?: throw IllegalStateException(
            "There is no dataset which meets the following condition(s): "
            + "InitialTableData.dataset_name == dataset.name (=$datasetName) "
            + "Possible values are: " + DatasetRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The table_model of this initial_table_data.
     */
    override val tableModel: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == tableModelName
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "InitialTableData.table_model_name == entity.name (=$tableModelName) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a initial_table_data or not.
     */
    override val isaInitialTableData: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllInitialTableDatas {
            return _context.get("initial_table_datas") as AllInitialTableDatas
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            InitialTableDataRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is InitialTableDataRecord) return false
        if (tableModelName != other.tableModelName) return false
        return true
    }

    override fun hashCode(): Int {
        var result = tableModelName.hashCode()
        return result
    }

    override fun toString(): String {
        return "InitialTableDataRecord(" +
            "tableModelName=$tableModelName" +
        ")"
    }
}
