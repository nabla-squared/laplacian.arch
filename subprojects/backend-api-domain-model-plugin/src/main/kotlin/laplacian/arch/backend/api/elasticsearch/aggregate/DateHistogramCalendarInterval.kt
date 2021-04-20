package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramInterval

import laplacian.util.*

/**
 * An entity describing a date_histogram_calendar_interval.
 */
interface DateHistogramCalendarInterval : DateHistogramInterval {
    /**
     * Returns wether this instance is a date_histogram_calendar_interval or not.
     */
    val isaDateHistogramCalendarInterval: Boolean
}
