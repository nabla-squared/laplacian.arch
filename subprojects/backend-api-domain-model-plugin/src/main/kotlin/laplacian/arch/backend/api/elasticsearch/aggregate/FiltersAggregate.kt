package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a filters_aggregate.
 */
interface FiltersAggregate : ElasticsearchAggregate {
    /**
     * The filters of this filters_aggregate.
     */
    val filters: List<KeyedFilter>
    /**
     * Returns wether this instance is a filters_aggregate or not.
     */
    val isaFiltersAggregate: Boolean
}
