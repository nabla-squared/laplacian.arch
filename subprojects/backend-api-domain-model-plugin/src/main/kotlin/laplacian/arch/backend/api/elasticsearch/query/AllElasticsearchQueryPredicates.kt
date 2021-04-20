package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_query_predicates.
 */
class AllElasticsearchQueryPredicates(
    list: List<ElasticsearchQueryPredicate>,
    val context: Context
) : List<ElasticsearchQueryPredicate> by list {
}
