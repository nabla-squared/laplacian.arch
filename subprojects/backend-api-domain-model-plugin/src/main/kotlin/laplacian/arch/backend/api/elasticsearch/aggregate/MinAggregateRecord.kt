package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord

import laplacian.generate.util.*
/**
 * An entity describing a min_aggregate.
 */
data class MinAggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchAggregateRecord(__record, _context), MinAggregate {

    /**
     * Returns wether this instance is a min_aggregate or not.
     */
    override val isaMinAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            MinAggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MinAggregateRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "MinAggregateRecord(" +
            "name=$name" +
        ")"
    }
}
