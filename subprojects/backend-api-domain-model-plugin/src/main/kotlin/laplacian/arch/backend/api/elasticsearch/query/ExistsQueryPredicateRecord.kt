package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a exists_query_predicate.
 */
data class ExistsQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), ExistsQueryPredicate {

    /**
     * The field of this exists_query_predicate.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * Returns wether this instance is a exists_query_predicate or not.
     */
    override val isaExistsQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ExistsQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ExistsQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "ExistsQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
