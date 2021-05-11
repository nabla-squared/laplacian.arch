package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All elasticsearch_client_configurations.
 */
class AllElasticsearchClientConfigurations(
    list: List<ElasticsearchClientConfiguration>,
    val context: Context
) : List<ElasticsearchClientConfiguration> by list {
}
