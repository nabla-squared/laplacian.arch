package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramInterval

import laplacian.util.*

/**
 * An entity describing a date_histogram_fixed_interval.
 */
interface DateHistogramFixedInterval : DateHistogramInterval {
    /**
     * Returns wether this instance is a date_histogram_fixed_interval or not.
     */
    val isaDateHistogramFixedInterval: Boolean
}
