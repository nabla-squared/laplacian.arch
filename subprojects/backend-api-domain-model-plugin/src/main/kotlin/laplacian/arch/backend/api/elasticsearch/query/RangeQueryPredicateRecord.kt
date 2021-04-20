package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a range_query_predicate.
 */
data class RangeQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), RangeQueryPredicate {

    /**
     * The field of this range_query_predicate.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * The from of this range_query_predicate.
     */
    override val from: String
        get() = getOrThrow("from")
    /**
     * The to of this range_query_predicate.
     */
    override val to: String
        get() = getOrThrow("to")
    /**
     * Defines this range_query_predicate is include_lower or not.
     */
    override val includeLower: Boolean?
        by _record
    /**
     * Defines this range_query_predicate is include_upper or not.
     */
    override val includeUpper: Boolean?
        by _record
    /**
     * The timezone of this range_query_predicate.
     */
    override val timezone: String?
        by _record
    /**
     * Returns wether this instance is a range_query_predicate or not.
     */
    override val isaRangeQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RangeQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RangeQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "RangeQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
