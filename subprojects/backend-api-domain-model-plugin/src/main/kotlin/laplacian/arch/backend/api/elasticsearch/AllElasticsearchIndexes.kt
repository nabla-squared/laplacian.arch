package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity

import laplacian.util.*

/**
 * All elasticsearch_indexes.
 */
class AllElasticsearchIndexes(
    list: List<ElasticsearchIndex>,
    val context: Context
) : List<ElasticsearchIndex> by list {
}
