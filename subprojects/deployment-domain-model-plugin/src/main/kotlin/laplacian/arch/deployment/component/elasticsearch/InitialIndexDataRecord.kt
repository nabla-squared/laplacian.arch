package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Dataset
import laplacian.arch.deployment.DatasetRecord
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord



import laplacian.generate.util.*
/**
 * An entity describing a initial_index_data.
 */
data class InitialIndexDataRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): InitialIndexData, Record by _record {

    /**
     * The index_name of this initial_index_data.
     */
    override val indexName: String
        get() = getOrThrow("indexName") {
            indexModelName
        }
    /**
     * The index_model_name of this initial_index_data.
     */
    override val indexModelName: String
        get() = getOrThrow("indexModelName") {
            indexName!!.lowerUnderscorize()
        }
    /**
     * The dataset_name of this initial_index_data.
     */
    override val datasetName: String
        get() = getOrThrow("datasetName")
    /**
     * The dataset of this initial_index_data.
     */
    override val dataset: Dataset by lazy {
        DatasetRecord.from(_context).find {
            it.name == datasetName
        } ?: throw IllegalStateException(
            "There is no dataset which meets the following condition(s): "
            + "InitialIndexData.dataset_name == dataset.name (=$datasetName) "
            + "Possible values are: " + DatasetRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The index_model of this initial_index_data.
     */
    override val indexModel: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == indexModelName
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "InitialIndexData.index_model_name == entity.name (=$indexModelName) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a initial_index_data or not.
     */
    override val isaInitialIndexData: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllInitialIndexDatas {
            return _context.get("initial_index_datas") as AllInitialIndexDatas
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            InitialIndexDataRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is InitialIndexDataRecord) return false
        if (indexModelName != other.indexModelName) return false
        return true
    }

    override fun hashCode(): Int {
        var result = indexModelName.hashCode()
        return result
    }

    override fun toString(): String {
        return "InitialIndexDataRecord(" +
            "indexModelName=$indexModelName" +
        ")"
    }
}
