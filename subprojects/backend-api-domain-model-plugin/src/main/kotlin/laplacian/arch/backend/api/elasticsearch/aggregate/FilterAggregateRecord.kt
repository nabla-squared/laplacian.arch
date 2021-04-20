package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a filter_aggregate.
 */
data class FilterAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), FilterAggregate {

    /**
     * The predicate of this filter_aggregate.
     */
    override val predicate: ElasticsearchQueryPredicate by lazy {
        ElasticsearchQueryPredicateRecord(getOrThrow<Record>("predicate"), _context)
    }
    /**
     * Returns wether this instance is a filter_aggregate or not.
     */
    override val isaFilterAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            FilterAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FilterAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "FilterAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
