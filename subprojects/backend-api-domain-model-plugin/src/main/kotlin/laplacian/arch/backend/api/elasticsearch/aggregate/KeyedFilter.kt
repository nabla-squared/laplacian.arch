package laplacian.arch.backend.api.elasticsearch.aggregate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate


import laplacian.util.*

/**
 * An entity describing a keyed_filter.
 */
interface KeyedFilter {
    /**
     * The key of this keyed_filter.
     */
    val key: String
    /**
     * The predicate of this keyed_filter.
     */
    val predicate: ElasticsearchQueryPredicate
    /**
     * Returns wether this instance is a keyed_filter or not.
     */
    val isaKeyedFilter: Boolean
}
