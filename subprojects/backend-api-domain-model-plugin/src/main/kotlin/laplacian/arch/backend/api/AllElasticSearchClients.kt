package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elastic_search_clients.
 */
class AllElasticSearchClients(
    list: List<ElasticSearchClient>,
    val context: Context
) : List<ElasticSearchClient> by list {
}
