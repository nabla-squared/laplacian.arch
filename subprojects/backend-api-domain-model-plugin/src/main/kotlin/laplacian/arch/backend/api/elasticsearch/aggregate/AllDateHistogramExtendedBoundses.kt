package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All date_histogram_extended_boundses.
 */
class AllDateHistogramExtendedBoundses(
    list: List<DateHistogramExtendedBounds>,
    val context: Context
) : List<DateHistogramExtendedBounds> by list {
}
