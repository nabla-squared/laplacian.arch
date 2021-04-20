package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.aggregate.KeyedFilter


import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a filters_aggregate.
 */
data class FiltersAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), FiltersAggregate {

    /**
     * The filters of this filters_aggregate.
     */
    override val filters: List<KeyedFilter> by lazy {
        KeyedFilterRecord.from(_record.getList("filters"), _context)
    }
    /**
     * Returns wether this instance is a filters_aggregate or not.
     */
    override val isaFiltersAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            FiltersAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FiltersAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "FiltersAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
