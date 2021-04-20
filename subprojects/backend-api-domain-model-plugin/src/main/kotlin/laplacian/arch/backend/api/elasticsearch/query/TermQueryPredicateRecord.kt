package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a term_query_predicate.
 */
data class TermQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), TermQueryPredicate {

    /**
     * The field of this term_query_predicate.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * The value of this term_query_predicate.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * The boost of this term_query_predicate.
     */
    override val boost: Int
        get() = getOrThrow("boost")
    /**
     * Returns wether this instance is a term_query_predicate or not.
     */
    override val isaTermQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            TermQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TermQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "TermQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
