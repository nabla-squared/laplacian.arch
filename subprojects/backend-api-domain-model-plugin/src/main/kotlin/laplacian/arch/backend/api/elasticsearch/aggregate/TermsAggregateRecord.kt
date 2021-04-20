package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * A multi-bucket value source based aggregation where buckets are dynamically built
- one per unique value.
 */
data class TermsAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), TermsAggregate {

    /**
     * The number of term buckets should be returned (default: 10)
     */
    override val maxBuckets: String?
        by _record
    /**
     * Defines this terms_aggregate is variable_max_buckets or not.
     */
    override val variableMaxBuckets: Boolean
        get() = maxBuckets?.contains("\${") ?: false
    /**
     * The sort order ('asc' or 'desc') in which the buckets will be returned
     */
    override val sortByCount: String?
        by _record
    /**
     * Defines this terms_aggregate is variable_order or not.
     */
    override val variableOrder: Boolean
        get() = sortByCount?.contains("\${") ?: false
    /**
     * The number of term buckets each shard will return to the coordinating node
(the node that coordinates the search execution)
     */
    override val shardSize: String?
        by _record
    /**
     * Defines this terms_aggregate is variable_shard_size or not.
     */
    override val variableShardSize: Boolean
        get() = shardSize?.contains("\${") ?: false
    /**
     * the minimum document count required per term
     */
    override val minDocCount: String?
        by _record
    /**
     * Defines this terms_aggregate is variable_min_doc_count or not.
     */
    override val variableMinDocCount: Boolean
        get() = minDocCount?.contains("\${") ?: false
    /**
     * Returns wether this instance is a terms_aggregate or not.
     */
    override val isaTermsAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            TermsAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TermsAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "TermsAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
