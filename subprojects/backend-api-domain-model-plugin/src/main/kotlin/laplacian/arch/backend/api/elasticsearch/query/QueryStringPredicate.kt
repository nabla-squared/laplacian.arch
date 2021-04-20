package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a query_string_predicate.
 */
interface QueryStringPredicate : ElasticsearchQueryPredicate {
    /**
     * The query of this query_string_predicate.
     */
    val query: String
    /**
     * The default_field of this query_string_predicate.
     */
    val defaultField: String?
    /**
     * Defines this query_string_predicate is allow_leading_wildcard or not.
     */
    val allowLeadingWildcard: Boolean?
    /**
     * Defines this query_string_predicate is analyze_wildcard or not.
     */
    val analyzeWildcard: Boolean?
    /**
     * The analyzer of this query_string_predicate.
     */
    val analyzer: String?
    /**
     * Defines this query_string_predicate is auto_generate_synonyms_phrase_query or not.
     */
    val autoGenerateSynonymsPhraseQuery: Boolean?
    /**
     * The boost of this query_string_predicate.
     */
    val boost: Float?
    /**
     * The default_operator of this query_string_predicate.
     */
    val defaultOperator: String?
    /**
     * Defines this query_string_predicate is enable_position_increments or not.
     */
    val enablePositionIncrements: Boolean?
    /**
     * The fields of this query_string_predicate.
     */
    val fields: List<String>
    /**
     * The fuzziness of this query_string_predicate.
     */
    val fuzziness: String?
    /**
     * The fuzzy_max_expansion of this query_string_predicate.
     */
    val fuzzyMaxExpansion: Int?
    /**
     * The fuzzy_prefix_length of this query_string_predicate.
     */
    val fuzzyPrefixLength: Int?
    /**
     * Defines this query_string_predicate is fuzzy_transpositions or not.
     */
    val fuzzyTranspositions: Boolean?
    /**
     * Defines this query_string_predicate is lenient or not.
     */
    val lenient: Boolean?
    /**
     * The max_determinized_states of this query_string_predicate.
     */
    val maxDeterminizedStates: Int?
    /**
     * The minimum_should_match of this query_string_predicate.
     */
    val minimumShouldMatch: String?
    /**
     * The quote_analyzer of this query_string_predicate.
     */
    val quoteAnalyzer: String?
    /**
     * The phrase_slop of this query_string_predicate.
     */
    val phraseSlop: Int?
    /**
     * The quote_field_suffix of this query_string_predicate.
     */
    val quoteFieldSuffix: String?
    /**
     * The rewrite of this query_string_predicate.
     */
    val rewrite: String?
    /**
     * The time_zone of this query_string_predicate.
     */
    val timeZone: String?
    /**
     * Returns wether this instance is a query_string_predicate or not.
     */
    val isaQueryStringPredicate: Boolean
}
