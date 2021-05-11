package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a term_query_predicate.
 */
interface TermQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * Field you wish to search.

     */
    val field: String
    /**
     * Term you wish to find in the provided <field>. To return a document,
the term must exactly match the field value, including whitespace and capitalization.

     */
    val value: String
    /**
     * Floating point number used to decrease or increase the relevance scores of a query.

     */
    val boost: Double?
    /**
     * Allows ASCII case insensitive matching of the value with the indexed field values when set to true.
Default is false which means the case sensitivity of matching depends on the underlying field’s mapping.

     */
    val caseInsensitive: Boolean?
    /**
     * Returns wether this instance is a term_query_predicate or not.
     */
    val isaTermQueryPredicate: Boolean
}
