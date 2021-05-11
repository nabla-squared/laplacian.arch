package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryCollapse
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryCollapseRecord
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySortRecord
import laplacian.arch.backend.api.aggregate.Aggregate


import laplacian.arch.backend.api.aggregate.AggregateAccessMethodRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_access_method.
 */
data class ElasticsearchAccessMethodRecord (
    private val __record: Record,
    private val _context: Context,
    override val aggregate: Aggregate,
    private val _record: Record = __record.normalizeCamelcase()
): AggregateAccessMethodRecord(__record, _context, aggregate), ElasticsearchAccessMethod {

    /**
     * The elasticsearch_client_name of this elasticsearch_access_method.
     */
    override val elasticsearchClientName: String?
        by _record
    /**
     * The index_name of this elasticsearch_access_method.
     */
    override val indexName: String
        get() = getOrThrow("indexName") {
            aggregate.rootEntity.tableName
        }
    /**
     * From index to start the search from.
     */
    override val offset: String
        get() = getOrThrow("offset") {
            "0"
        }
    /**
     * The maximum number of search hits to return.
     */
    override val limit: String
        get() = getOrThrow("limit") {
            "10"
        }
    /**
     * The query of this elasticsearch_access_method.
     */
    override val query: ElasticsearchQueryPredicate by lazy {
        ElasticsearchQueryPredicateRecord(getOrThrow<Record>("query"), _context)
    }
    /**
     * Field collapsing on search request.
     */
    override val collapse: ElasticsearchQueryCollapse? by lazy {
        getOrNull<Record>("collapse")?.let{ ElasticsearchQueryCollapseRecord.from(it, _context) }
    }
    /**
     * The sort of this elasticsearch_access_method.
     */
    override val sort: List<ElasticsearchQuerySort> by lazy {
        ElasticsearchQuerySortRecord.from(_record.getList("sort", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_access_method or not.
     */
    override val isaElasticsearchAccessMethod: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, aggregate: Aggregate) = records
            .mergeWithKeys("name")
            .map { from(it, _context, aggregate = aggregate) }

        fun from(record: Record, _context: Context, aggregate: Aggregate) =
            ElasticsearchAccessMethodRecord(record, _context, aggregate = aggregate)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchAccessMethodRecord) return false
        if (aggregate != other.aggregate) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = aggregate.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchAccessMethodRecord(" +
            "aggregate=$aggregate, " +
            "name=$name" +
        ")"
    }
}
