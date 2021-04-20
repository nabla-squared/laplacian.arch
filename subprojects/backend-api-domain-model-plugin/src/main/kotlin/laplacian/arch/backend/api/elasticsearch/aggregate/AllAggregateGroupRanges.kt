package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All aggregate_group_ranges.
 */
class AllAggregateGroupRanges(
    list: List<AggregateGroupRange>,
    val context: Context
) : List<AggregateGroupRange> by list {
}
