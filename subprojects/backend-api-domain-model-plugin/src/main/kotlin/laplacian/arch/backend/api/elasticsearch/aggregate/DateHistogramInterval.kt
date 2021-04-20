package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a date_histogram_interval.
 */
interface DateHistogramInterval {
    /**
     * The type of this date_histogram_interval.
     */
    val type: String
    /**
     * The unit of this date_histogram_interval.
     */
    val unit: String
    /**
     * The value of this date_histogram_interval.
     */
    val value: String
    /**
     * Defines this date_histogram_interval is variable_unit or not.
     */
    val variableUnit: Boolean
    /**
     * Defines this date_histogram_interval is variable_value or not.
     */
    val variableValue: Boolean
    /**
     * Returns wether this instance is a date_histogram_interval or not.
     */
    val isaDateHistogramInterval: Boolean
}
