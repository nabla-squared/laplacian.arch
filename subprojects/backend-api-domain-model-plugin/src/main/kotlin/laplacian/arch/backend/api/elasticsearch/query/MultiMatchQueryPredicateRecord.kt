package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a multi_match_query_predicate.
 */
data class MultiMatchQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), MultiMatchQueryPredicate {

    /**
     * The value of this multi_match_query_predicate.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * The fields of this multi_match_query_predicate.
     */
    override val fields: List<String>
        get() = getOrThrow("fields") {
            emptyList<String>()
        }
    /**
     * Returns wether this instance is a multi_match_query_predicate or not.
     */
    override val isaMultiMatchQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            MultiMatchQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MultiMatchQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "MultiMatchQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
