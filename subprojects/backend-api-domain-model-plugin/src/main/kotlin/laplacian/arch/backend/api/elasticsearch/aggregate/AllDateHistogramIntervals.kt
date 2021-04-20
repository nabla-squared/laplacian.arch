package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All date_histogram_intervals.
 */
class AllDateHistogramIntervals(
    list: List<DateHistogramInterval>,
    val context: Context
) : List<DateHistogramInterval> by list {
}
