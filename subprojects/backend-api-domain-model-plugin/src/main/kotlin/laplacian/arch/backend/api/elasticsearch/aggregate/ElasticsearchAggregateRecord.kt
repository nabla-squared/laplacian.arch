package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context



import laplacian.arch.backend.api.elasticsearch.aggregate.AvgBucketAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.BucketScriptAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.BucketSelectorAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.BucketSortAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.DateRangeAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.FilterAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.FiltersAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.SumAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AvgAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.MinAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.MaxAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.ValueCountAggregateRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.TermsAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_aggregate.
 */
open class ElasticsearchAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregate, Record by _record {

    /**
     * The name of this elasticsearch_aggregate.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this elasticsearch_aggregate.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${name} ${aggregationType} aggregation"
        }
    /**
     * The aggregation_type of this elasticsearch_aggregate.
     */
    override val aggregationType: String
        get() = getOrThrow("aggregationType")
    /**
     * The field of this elasticsearch_aggregate.
     */
    override val field: String?
        by _record
    /**
     * The sub_aggregates of this elasticsearch_aggregate.
     */
    override val subAggregates: List<ElasticsearchAggregate> by lazy {
        ElasticsearchAggregateRecord.from(_record.getList("sub_aggregates", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_aggregate or not.
     */
    override val isaElasticsearchAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchAggregates {
            return _context.get("elasticsearch_aggregates") as AllElasticsearchAggregates
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["aggregation_type"]) {
                "avg_bucket" -> AvgBucketAggregateRecord(record, _context)
                "bucket_script" -> BucketScriptAggregateRecord(record, _context)
                "bucket_selector" -> BucketSelectorAggregateRecord(record, _context)
                "bucket_sort" -> BucketSortAggregateRecord(record, _context)
                "date_histogram" -> DateHistogramAggregateRecord(record, _context)
                "date_range" -> DateRangeAggregateRecord(record, _context)
                "filter" -> FilterAggregateRecord(record, _context)
                "filters" -> FiltersAggregateRecord(record, _context)
                "sum" -> SumAggregateRecord(record, _context)
                "avg" -> AvgAggregateRecord(record, _context)
                "min" -> MinAggregateRecord(record, _context)
                "max" -> MaxAggregateRecord(record, _context)
                "count" -> ValueCountAggregateRecord(record, _context)
                "terms" -> TermsAggregateRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined aggregation_type $type. It is should be one of [avg_bucket, bucket_script, bucket_selector, bucket_sort, date_histogram, date_range, filter, filters, sum, avg, min, max, count, terms]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
