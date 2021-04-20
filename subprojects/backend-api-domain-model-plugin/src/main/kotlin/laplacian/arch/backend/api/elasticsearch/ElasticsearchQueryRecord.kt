package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySortRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord
import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.ApiCallArgumentRecord



import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query.
 */
data class ElasticsearchQueryRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQuery, Record by _record {

    /**
     * The name of this elasticsearch_query.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The index_name of this elasticsearch_query.
     */
    override val indexName: String
        get() = getOrThrow("indexName")
    /**
     * The description of this elasticsearch_query.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${name}"
        }
    /**
     * The size of the page to be returned
     */
    override val pageSize: String
        get() = getOrThrow("pageSize") {
            "200"
        }
    /**
     * Defines this elasticsearch_query is variable_page_size or not.
     */
    override val variablePageSize: Boolean
        get() = pageSize?.contains("\${") ?: false
    /**
     * Zero-based page index.
     */
    override val pageNumber: String
        get() = getOrThrow("pageNumber") {
            "0"
        }
    /**
     * Defines this elasticsearch_query is variable_page_number or not.
     */
    override val variablePageNumber: Boolean
        get() = pageNumber?.contains("\${") ?: false
    /**
     * The predicate of this elasticsearch_query.
     */
    override val predicate: ElasticsearchQueryPredicate? by lazy {
        getOrNull<Record>("predicate")?.let{ ElasticsearchQueryPredicateRecord.from(it, _context) }
    }
    /**
     * The sort of this elasticsearch_query.
     */
    override val sort: List<ElasticsearchQuerySort> by lazy {
        ElasticsearchQuerySortRecord.from(_record.getList("sort", emptyList()), _context)
    }
    /**
     * The aggregates of this elasticsearch_query.
     */
    override val aggregates: List<ElasticsearchAggregate> by lazy {
        ElasticsearchAggregateRecord.from(_record.getList("aggregates", emptyList()), _context)
    }
    /**
     * The parameters of this elasticsearch_query.
     */
    override val parameters: List<ApiCallArgument> by lazy {
        ApiCallArgumentRecord.from(_record.getList("parameters", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_query or not.
     */
    override val isaElasticsearchQuery: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchQueries {
            return _context.get("elasticsearch_queries") as AllElasticsearchQueries
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchQueryRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQueryRecord) return false
        if (name != other.name) return false
        if (indexName != other.indexName) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + indexName.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQueryRecord(" +
            "name=$name, " +
            "indexName=$indexName" +
        ")"
    }
}
