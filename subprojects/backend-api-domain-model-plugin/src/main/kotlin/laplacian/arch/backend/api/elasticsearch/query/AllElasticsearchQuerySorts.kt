package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_query_sorts.
 */
class AllElasticsearchQuerySorts(
    list: List<ElasticsearchQuerySort>,
    val context: Context
) : List<ElasticsearchQuerySort> by list {
}
