package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.AggregateEntry
import laplacian.arch.backend.api.aggregate.Aggregate
import laplacian.arch.backend.api.rest.RestResourceEntry
import laplacian.arch.backend.api.rest.RestResource
import laplacian.arch.backend.api.datasource.Datasource
import laplacian.arch.backend.api.elasticsearch.ElasticsearchClient
import laplacian.arch.backend.api.graphql.GraphqlType
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndex
import laplacian.arch.backend.api.graphql.GraphqlField
import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher
import laplacian.arch.backend.api.cache.CachePolicy
import laplacian.arch.backend.api.cache.RedisCachePolicy
import laplacian.arch.backend.api.data_file.DataFileFetcher
import laplacian.arch.backend.api.data_file.DataFile
import laplacian.arch.backend.api.rest.RestApiFetcher

import laplacian.util.*

/**
 * All services.
 */
class AllServices(
    list: List<Service>,
    val context: Context
) : List<Service> by list {
    val inNamespace: List<Service>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
