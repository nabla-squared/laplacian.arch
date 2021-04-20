package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate

import laplacian.util.*

/**
 * All keyed_filters.
 */
class AllKeyedFilters(
    list: List<KeyedFilter>,
    val context: Context
) : List<KeyedFilter> by list {
}
