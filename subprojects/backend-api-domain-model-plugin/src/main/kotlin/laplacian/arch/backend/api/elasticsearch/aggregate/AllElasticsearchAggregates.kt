package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_aggregates.
 */
class AllElasticsearchAggregates(
    list: List<ElasticsearchAggregate>,
    val context: Context
) : List<ElasticsearchAggregate> by list {
}
