package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_query_collapses.
 */
class AllElasticsearchQueryCollapses(
    list: List<ElasticsearchQueryCollapse>,
    val context: Context
) : List<ElasticsearchQueryCollapse> by list {
}
