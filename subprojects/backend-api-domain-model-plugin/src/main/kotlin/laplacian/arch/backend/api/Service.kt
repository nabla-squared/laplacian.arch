package laplacian.arch.backend.api
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
 * An entity describing a service.
 */
interface Service {
    /**
     * The name of this service.
     */
    val name: String
    /**
     * The namespace of this service.
     */
    val namespace: String
    /**
     * The version of this service.
     */
    val version: String
    /**
     * The description of this service.
     */
    val description: String
    /**
     * The graphql_type_groups of this service.
     */
    val graphqlTypeGroups: List<String>
    /**
     * Defines this service is depends_on_elasticsearch or not.
     */
    val dependsOnElasticsearch: Boolean
    /**
     * Defines this service is depends_on_cache or not.
     */
    val dependsOnCache: Boolean
    /**
     * Defines this service is depends_on_data_file or not.
     */
    val dependsOnDataFile: Boolean
    /**
     * Defines this service is depends_on_redis_cache or not.
     */
    val dependsOnRedisCache: Boolean
    /**
     * Defines this service is depends_on_mybatis or not.
     */
    val dependsOnMybatis: Boolean
    /**
     * Defines this service is depends_on_blocking_postgres_datasource or not.
     */
    val dependsOnBlockingPostgresDatasource: Boolean
    /**
     * Defines this service is depends_on_blocking_mysql_datasource or not.
     */
    val dependsOnBlockingMysqlDatasource: Boolean
    /**
     * Defines this service is depends_on_blocking_oracle_datasource or not.
     */
    val dependsOnBlockingOracleDatasource: Boolean
    /**
     * Defines this service is has_custom_logic or not.
     */
    val hasCustomLogic: Boolean
    /**
     * The instrumentations of this service.
     */
    val instrumentations: List<String>
    /**
     * The aggregate_entries of this service.
     */
    val aggregateEntries: List<AggregateEntry>
    /**
     * The aggregates of this service.
     */
    val aggregates: List<Aggregate>
    /**
     * The rest_resource_entries of this service.
     */
    val restResourceEntries: List<RestResourceEntry>
    /**
     * The rest_resources of this service.
     */
    val restResources: List<RestResource>
    /**
     * The datasource_entries of this service.
     */
    val datasourceEntries: List<DatasourceEntry>
    /**
     * The datasources of this service.
     */
    val datasources: List<Datasource>
    /**
     * The primary_datasource of this service.
     */
    val primaryDatasource: Datasource?
    /**
     * The blocking_datasources of this service.
     */
    val blockingDatasources: List<Datasource>
    /**
     * The non_blocking_datasources of this service.
     */
    val nonBlockingDatasources: List<Datasource>
    /**
     * The elasticsearch_clients of this service.
     */
    val elasticsearchClients: List<ElasticsearchClient>
    /**
     * The primary_elasticsearch_client of this service.
     */
    val primaryElasticsearchClient: ElasticsearchClient?
    /**
     * The graphql_type_entries of this service.
     */
    val graphqlTypeEntries: List<GraphqlTypeEntry>
    /**
     * The graphql_types of this service.
     */
    val graphqlTypes: List<GraphqlType>
    /**
     * The root_graphql_types of this service.
     */
    val rootGraphqlTypes: List<GraphqlType>
    /**
     * The elasticsearch_indexes of this service.
     */
    val elasticsearchIndexes: List<ElasticsearchIndex>
    /**
     * The graphql_fields of this service.
     */
    val graphqlFields: List<GraphqlField>
    /**
     * The graphql_field_fetchers of this service.
     */
    val graphqlFieldFetchers: List<GraphqlFieldFetcher>
    /**
     * The cache_policies of this service.
     */
    val cachePolicies: List<CachePolicy>
    /**
     * The redis_cache_policies of this service.
     */
    val redisCachePolicies: List<RedisCachePolicy>
    /**
     * The data_file_fetchers of this service.
     */
    val dataFileFetchers: List<DataFileFetcher>
    /**
     * The data_files of this service.
     */
    val dataFiles: List<DataFile>
    /**
     * The rest_api_fetchers of this service.
     */
    val restApiFetchers: List<RestApiFetcher>
    /**
     * The configurations of this service.
     */
    val configurations: List<ServiceConfiguration>
    /**
     * Returns wether this instance is a service or not.
     */
    val isaService: Boolean
}
