package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord

import laplacian.generate.util.*
/**
 * An entity describing a query_string_predicate.
 */
data class QueryStringPredicateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryPredicateRecord(__record, _context), QueryStringPredicate {

    /**
     * The query of this query_string_predicate.
     */
    override val query: String
        get() = getOrThrow("query")
    /**
     * The default_field of this query_string_predicate.
     */
    override val defaultField: String?
        by _record
    /**
     * Defines this query_string_predicate is allow_leading_wildcard or not.
     */
    override val allowLeadingWildcard: Boolean?
        by _record
    /**
     * Defines this query_string_predicate is analyze_wildcard or not.
     */
    override val analyzeWildcard: Boolean?
        by _record
    /**
     * The analyzer of this query_string_predicate.
     */
    override val analyzer: String?
        by _record
    /**
     * Defines this query_string_predicate is auto_generate_synonyms_phrase_query or not.
     */
    override val autoGenerateSynonymsPhraseQuery: Boolean?
        by _record
    /**
     * The boost of this query_string_predicate.
     */
    override val boost: Float?
        by _record
    /**
     * The default_operator of this query_string_predicate.
     */
    override val defaultOperator: String?
        by _record
    /**
     * Defines this query_string_predicate is enable_position_increments or not.
     */
    override val enablePositionIncrements: Boolean?
        by _record
    /**
     * The fields of this query_string_predicate.
     */
    override val fields: List<String>
        get() = getOrThrow("fields") {
            emptyList<String>()
        }
    /**
     * The fuzziness of this query_string_predicate.
     */
    override val fuzziness: String?
        by _record
    /**
     * The fuzzy_max_expansion of this query_string_predicate.
     */
    override val fuzzyMaxExpansion: Int?
        by _record
    /**
     * The fuzzy_prefix_length of this query_string_predicate.
     */
    override val fuzzyPrefixLength: Int?
        by _record
    /**
     * Defines this query_string_predicate is fuzzy_transpositions or not.
     */
    override val fuzzyTranspositions: Boolean?
        by _record
    /**
     * Defines this query_string_predicate is lenient or not.
     */
    override val lenient: Boolean?
        by _record
    /**
     * The max_determinized_states of this query_string_predicate.
     */
    override val maxDeterminizedStates: Int?
        by _record
    /**
     * The minimum_should_match of this query_string_predicate.
     */
    override val minimumShouldMatch: String?
        by _record
    /**
     * The quote_analyzer of this query_string_predicate.
     */
    override val quoteAnalyzer: String?
        by _record
    /**
     * The phrase_slop of this query_string_predicate.
     */
    override val phraseSlop: Int?
        by _record
    /**
     * The quote_field_suffix of this query_string_predicate.
     */
    override val quoteFieldSuffix: String?
        by _record
    /**
     * The rewrite of this query_string_predicate.
     */
    override val rewrite: String?
        by _record
    /**
     * The time_zone of this query_string_predicate.
     */
    override val timeZone: String?
        by _record
    /**
     * Returns wether this instance is a query_string_predicate or not.
     */
    override val isaQueryStringPredicate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            QueryStringPredicateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is QueryStringPredicateRecord) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        return result
    }

    override fun toString(): String {
        return "QueryStringPredicateRecord(" +
            "type=$type" +
        ")"
    }
}
