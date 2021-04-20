package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a avg_bucket_aggregate.
 */
data class AvgBucketAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), AvgBucketAggregate {

    /**
     * The buckets_path of this avg_bucket_aggregate.
     */
    override val bucketsPath: String
        get() = getOrThrow("bucketsPath")
    /**
     * Returns wether this instance is a avg_bucket_aggregate or not.
     */
    override val isaAvgBucketAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            AvgBucketAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AvgBucketAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "AvgBucketAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
