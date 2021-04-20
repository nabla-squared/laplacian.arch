package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord
import laplacian.arch.backend.api.elasticsearch.ElasticsearchQuery

import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexSort




import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_index.
 */
data class ElasticsearchIndexRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchIndex, Record by _record {

    /**
     * The name of this elasticsearch_index.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this elasticsearch_index.
     */
    override val description: String
        get() = getOrThrow("description") {
            "elasticsearch index schema of ${name}"
        }
    /**
     * The document_model_name of this elasticsearch_index.
     */
    override val documentModelName: String
        get() = getOrThrow("documentModelName")
    /**
     * The document_model of this elasticsearch_index.
     */
    override val documentModel: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == documentModelName
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "ElasticsearchIndex.document_model_name == entity.name (=$documentModelName) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The queries of this elasticsearch_index.
     */
    override val queries: List<ElasticsearchQuery> by lazy {
        ElasticsearchQueryRecord.from(_context).filter {
            it.indexName == name
        }
    }
    /**
     * The default_sorts of this elasticsearch_index.
     */
    override val defaultSorts: List<ElasticsearchIndexSort> by lazy {
        ElasticsearchIndexSortRecord.from(_record.getList("default_sorts", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_index or not.
     */
    override val isaElasticsearchIndex: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchIndexes {
            return _context.get("elasticsearch_indexes") as AllElasticsearchIndexes
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchIndexRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchIndexRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchIndexRecord(" +
            "name=$name" +
        ")"
    }
}
