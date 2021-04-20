package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * An entity describing a match_all_query_predicate.
 */
interface MatchAllQueryPredicate : ElasticsearchQueryPredicate {
    /**
     * Returns wether this instance is a match_all_query_predicate or not.
     */
    val isaMatchAllQueryPredicate: Boolean
}
