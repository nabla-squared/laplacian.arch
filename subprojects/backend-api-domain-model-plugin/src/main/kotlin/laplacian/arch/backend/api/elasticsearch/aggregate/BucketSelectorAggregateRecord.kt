package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.aggregate.BucketScriptPath


import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a bucket_selector_aggregate.
 */
data class BucketSelectorAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), BucketSelectorAggregate {

    /**
     * The script of this bucket_selector_aggregate.
     */
    override val script: String
        get() = getOrThrow("script")
    /**
     * The buckets_path of this bucket_selector_aggregate.
     */
    override val bucketsPath: List<BucketScriptPath> by lazy {
        BucketScriptPathRecord.from(_record.getList("buckets_path"), _context)
    }
    /**
     * Returns wether this instance is a bucket_selector_aggregate or not.
     */
    override val isaBucketSelectorAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            BucketSelectorAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BucketSelectorAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "BucketSelectorAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
