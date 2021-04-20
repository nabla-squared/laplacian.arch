package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.aggregate.FieldSort


import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a bucket_sort_aggregate.
 */
data class BucketSortAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), BucketSortAggregate {

    /**
     * Zero-based from index.
     */
    override val from: String?
        by _record
    /**
     * Defines this bucket_sort_aggregate is variable_from or not.
     */
    override val variableFrom: Boolean
        get() = from?.contains("\${") ?: false
    /**
     * The size of the bucket_sort to be returned.
     */
    override val bucketSize: String?
        by _record
    /**
     * Defines this bucket_sort_aggregate is variable_bucket_size or not.
     */
    override val variableBucketSize: Boolean
        get() = bucketSize?.contains("\${") ?: false
    /**
     * The sorts of this bucket_sort_aggregate.
     */
    override val sorts: List<FieldSort> by lazy {
        FieldSortRecord.from(_record.getList("sorts"), _context)
    }
    /**
     * Returns wether this instance is a bucket_sort_aggregate or not.
     */
    override val isaBucketSortAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            BucketSortAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BucketSortAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "BucketSortAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
