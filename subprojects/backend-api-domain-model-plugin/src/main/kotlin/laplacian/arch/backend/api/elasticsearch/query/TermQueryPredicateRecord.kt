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
     * Field you wish to search.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * Term you wish to find in the provided <field>. To return a document,
the term must exactly match the field value, including whitespace and capitalization.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * Floating point number used to decrease or increase the relevance scores of a query.
     */
    override val boost: Double?
        by _record
    /**
     * Allows ASCII case insensitive matching of the value with the indexed field values when set to true.
Default is false which means the case sensitivity of matching depends on the underlying field’s mapping.
     */
    override val caseInsensitive: Boolean?
        by _record
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
