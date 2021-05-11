package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_clients.
 */
class AllElasticsearchClients(
    list: List<ElasticsearchClient>,
    val context: Context
) : List<ElasticsearchClient> by list {
}
