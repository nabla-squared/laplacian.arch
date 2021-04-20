package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate
import laplacian.arch.backend.api.ApiCallArgument

import laplacian.util.*

/**
 * All elasticsearch_queries.
 */
class AllElasticsearchQueries(
    list: List<ElasticsearchQuery>,
    val context: Context
) : List<ElasticsearchQuery> by list {
}
