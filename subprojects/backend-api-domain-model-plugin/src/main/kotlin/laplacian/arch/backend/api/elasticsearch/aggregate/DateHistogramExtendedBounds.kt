package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a date_histogram_extended_bounds.
 */
interface DateHistogramExtendedBounds {
    /**
     * The min of this date_histogram_extended_bounds.
     */
    val min: String?
    /**
     * The max of this date_histogram_extended_bounds.
     */
    val max: String?
    /**
     * Returns wether this instance is a date_histogram_extended_bounds or not.
     */
    val isaDateHistogramExtendedBounds: Boolean
}
