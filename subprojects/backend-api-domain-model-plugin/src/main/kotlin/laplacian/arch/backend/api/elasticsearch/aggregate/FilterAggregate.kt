package laplacian.arch.backend.api.elasticsearch.aggregate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a filter_aggregate.
 */
interface FilterAggregate : ElasticsearchAggregate {
    /**
     * The predicate of this filter_aggregate.
     */
    val predicate: ElasticsearchQueryPredicate
    /**
     * Returns wether this instance is a filter_aggregate or not.
     */
    val isaFilterAggregate: Boolean
}
