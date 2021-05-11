package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * The wildcard search query. Supported wildcards are *, which matches any character sequence
(including the empty one), and ?, which matches any single character. Note this query can be slow,
as it needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
a Wildcard term should not start with one of the wildcards * or ?.
(The wildcard field type however, is optimized for leading wildcards)
 */
data class WildcardQueryPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), WildcardQueryPredicate {

    /**
     * Field you wish to search.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * Wildcard pattern for terms you wish to find.
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
     * The rewrite of this wildcard_query_predicate.
     */
    override val rewrite: String?
        by _record
    /**
     * Returns wether this instance is a wildcard_query_predicate or not.
     */
    override val isaWildcardQueryPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            WildcardQueryPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WildcardQueryPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "WildcardQueryPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
