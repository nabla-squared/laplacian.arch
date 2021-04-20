package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a date_histogram_aggregate.
 */
interface DateHistogramAggregate : ElasticsearchAggregate {
    /**
     * The format of this date_histogram_aggregate.
     */
    val format: String?
    /**
     * The timezone of this date_histogram_aggregate.
     */
    val timezone: String?
    /**
     * the minimum document count required per bucket

     */
    val minDocCount: String?
    /**
     * Defines this date_histogram_aggregate is variable_min_doc_count or not.
     */
    val variableMinDocCount: Boolean
    /**
     * The interval of this date_histogram_aggregate.
     */
    val interval: DateHistogramInterval
    /**
     * The extended_bounds of this date_histogram_aggregate.
     */
    val extendedBounds: DateHistogramExtendedBounds?
    /**
     * Returns wether this instance is a date_histogram_aggregate or not.
     */
    val isaDateHistogramAggregate: Boolean
}
