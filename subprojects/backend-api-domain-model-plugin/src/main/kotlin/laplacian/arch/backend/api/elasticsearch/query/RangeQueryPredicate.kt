package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a range_query_predicate.
 */
interface RangeQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * The field of this range_query_predicate.
     */
    val field: String
    /**
     * The from of this range_query_predicate.
     */
    val from: String
    /**
     * The to of this range_query_predicate.
     */
    val to: String
    /**
     * Defines this range_query_predicate is include_lower or not.
     */
    val includeLower: Boolean?
    /**
     * Defines this range_query_predicate is include_upper or not.
     */
    val includeUpper: Boolean?
    /**
     * The timezone of this range_query_predicate.
     */
    val timezone: String?
    /**
     * Returns wether this instance is a range_query_predicate or not.
     */
    val isaRangeQueryPredicate: Boolean
}
