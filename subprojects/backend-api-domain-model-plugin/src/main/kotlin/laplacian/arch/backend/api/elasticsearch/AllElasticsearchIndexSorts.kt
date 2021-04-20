package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_index_sorts.
 */
class AllElasticsearchIndexSorts(
    list: List<ElasticsearchIndexSort>,
    val context: Context
) : List<ElasticsearchIndexSort> by list {
}
