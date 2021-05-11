package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.AggregateEntry
import laplacian.arch.backend.api.aggregate.AggregateEntryRecord
import laplacian.arch.backend.api.aggregate.Aggregate
import laplacian.arch.backend.api.aggregate.AggregateRecord
import laplacian.arch.backend.api.rest.RestResourceEntry
import laplacian.arch.backend.api.rest.RestResourceEntryRecord
import laplacian.arch.backend.api.rest.RestResource
import laplacian.arch.backend.api.rest.RestResourceRecord
import laplacian.arch.backend.api.DatasourceEntry

import laplacian.arch.backend.api.datasource.Datasource
import laplacian.arch.backend.api.datasource.DatasourceRecord
import laplacian.arch.backend.api.elasticsearch.ElasticsearchClient
import laplacian.arch.backend.api.elasticsearch.ElasticsearchClientRecord
import laplacian.arch.backend.api.GraphqlTypeEntry

import laplacian.arch.backend.api.graphql.GraphqlType
import laplacian.arch.backend.api.graphql.GraphqlTypeRecord
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndex
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexRecord
import laplacian.arch.backend.api.graphql.GraphqlField
import laplacian.arch.backend.api.graphql.GraphqlFieldRecord
import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher
import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord
import laplacian.arch.backend.api.cache.CachePolicy
import laplacian.arch.backend.api.cache.CachePolicyRecord
import laplacian.arch.backend.api.cache.RedisCachePolicy
import laplacian.arch.backend.api.cache.RedisCachePolicyRecord
import laplacian.arch.backend.api.data_file.DataFileFetcher
import laplacian.arch.backend.api.data_file.DataFileFetcherRecord
import laplacian.arch.backend.api.data_file.DataFile
import laplacian.arch.backend.api.data_file.DataFileRecord
import laplacian.arch.backend.api.rest.RestApiFetcher
import laplacian.arch.backend.api.rest.RestApiFetcherRecord
import laplacian.arch.backend.api.ServiceConfiguration




import laplacian.generate.util.*
/**
 * An entity describing a service.
 */
data class ServiceRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Service, Record by _record {

    /**
     * The name of this service.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this service.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The version of this service.
     */
    override val version: String
        get() = getOrThrow("version")
    /**
     * The description of this service.
     */
    override val description: String
        get() = getOrThrow("description") {
            name
        }
    /**
     * The graphql_type_groups of this service.
     */
    override val graphqlTypeGroups: List<String>
        get() = graphqlTypes.map{ it.group }.filterNotNull().distinct()
    /**
     * Defines this service is depends_on_elasticsearch or not.
     */
    override val dependsOnElasticsearch: Boolean
        get() = elasticsearchIndexes.isNotEmpty() || aggregates.any{ it.dependsOnElasticsearch }
    /**
     * Defines this service is depends_on_cache or not.
     */
    override val dependsOnCache: Boolean
        get() = cachePolicies.isNotEmpty()
    /**
     * Defines this service is depends_on_data_file or not.
     */
    override val dependsOnDataFile: Boolean
        get() = dataFiles.isNotEmpty()
    /**
     * Defines this service is depends_on_redis_cache or not.
     */
    override val dependsOnRedisCache: Boolean
        get() = redisCachePolicies.isNotEmpty()
    /**
     * Defines this service is depends_on_mybatis or not.
     */
    override val dependsOnMybatis: Boolean
        get() = graphqlTypes.any{ it.dependsOnMybatis } || aggregates.any{ it.dependsOnMybatis }
    /**
     * Defines this service is depends_on_blocking_postgres_datasource or not.
     */
    override val dependsOnBlockingPostgresDatasource: Boolean
        get() = blockingDatasources.any { it.dbType == "postgres" }
    /**
     * Defines this service is depends_on_blocking_mysql_datasource or not.
     */
    override val dependsOnBlockingMysqlDatasource: Boolean
        get() = blockingDatasources.any { it.dbType == "mysql" }
    /**
     * Defines this service is depends_on_blocking_oracle_datasource or not.
     */
    override val dependsOnBlockingOracleDatasource: Boolean
        get() = blockingDatasources.any { it.dbType == "oracle" }
    /**
     * Defines this service is has_custom_logic or not.
     */
    override val hasCustomLogic: Boolean
        get() = graphqlFieldFetchers.any{ it.type == "custom" }
    /**
     * The instrumentations of this service.
     */
    override val instrumentations: List<String>
        get() = getOrThrow("instrumentations") {
            emptyList<String>()
        }
    /**
     * The aggregate_entries of this service.
     */
    override val aggregateEntries: List<AggregateEntry> by lazy {
        AggregateEntryRecord.from(_record.getList("aggregate_entries", emptyList()), _context)
    }
    /**
     * The aggregates of this service.
     */
    override val aggregates: List<Aggregate> by lazy {
        aggregateEntries.map{ it.aggregate }
    }
    /**
     * The rest_resource_entries of this service.
     */
    override val restResourceEntries: List<RestResourceEntry> by lazy {
        RestResourceEntryRecord.from(_record.getList("rest_resource_entries", emptyList()), _context)
    }
    /**
     * The rest_resources of this service.
     */
    override val restResources: List<RestResource> by lazy {
        restResourceEntries.map{ it.restResource }
    }
    /**
     * The datasource_entries of this service.
     */
    override val datasourceEntries: List<DatasourceEntry> by lazy {
        DatasourceEntryRecord.from(_record.getList("datasource_entries", emptyList()), _context)
    }
    /**
     * The datasources of this service.
     */
    override val datasources: List<Datasource> by lazy {
        datasourceEntries.map{ it.datasource }.distinct()
    }
    /**
     * The primary_datasource of this service.
     */
    override val primaryDatasource: Datasource? by lazy {
        datasourceEntries.find{ it.primary }?.datasource
    }
    /**
     * The blocking_datasources of this service.
     */
    override val blockingDatasources: List<Datasource> by lazy {
        datasources.filter{ !it.nonBlocking }
    }
    /**
     * The non_blocking_datasources of this service.
     */
    override val nonBlockingDatasources: List<Datasource> by lazy {
        datasources.filter{ it.nonBlocking }
    }
    /**
     * The elasticsearch_clients of this service.
     */
    override val elasticsearchClients: List<ElasticsearchClient> by lazy {
        ElasticsearchClientRecord.from(_record.getList("elasticsearch_clients", emptyList()), _context)
    }
    /**
     * The primary_elasticsearch_client of this service.
     */
    override val primaryElasticsearchClient: ElasticsearchClient? by lazy {
        elasticsearchClients.find{ it.primary }
    }
    /**
     * The graphql_type_entries of this service.
     */
    override val graphqlTypeEntries: List<GraphqlTypeEntry> by lazy {
        GraphqlTypeEntryRecord.from(_record.getList("graphql_type_entries", emptyList()), _context, this)
    }
    /**
     * The graphql_types of this service.
     */
    override val graphqlTypes: List<GraphqlType> by lazy {
        graphqlTypeEntries.map{ it.graphqlType }.distinct()
    }
    /**
     * The root_graphql_types of this service.
     */
    override val rootGraphqlTypes: List<GraphqlType> by lazy {
        graphqlTypes.filter{ it.group == null }
    }
    /**
     * The elasticsearch_indexes of this service.
     */
    override val elasticsearchIndexes: List<ElasticsearchIndex> by lazy {
        listOf<ElasticsearchIndex>()
    }
    /**
     * The graphql_fields of this service.
     */
    override val graphqlFields: List<GraphqlField> by lazy {
        graphqlTypes
        .flatMap{ it.fields ?: emptyList() }
    }
    /**
     * The graphql_field_fetchers of this service.
     */
    override val graphqlFieldFetchers: List<GraphqlFieldFetcher> by lazy {
        graphqlFields.map{ it.fetcher }.filterNotNull()
    }
    /**
     * The cache_policies of this service.
     */
    override val cachePolicies: List<CachePolicy> by lazy {
        graphqlFieldFetchers.map{ it.cachePolicy }.filterNotNull()
    }
    /**
     * The redis_cache_policies of this service.
     */
    override val redisCachePolicies: List<RedisCachePolicy> by lazy {
        cachePolicies.filterIsInstance<RedisCachePolicy>()
    }
    /**
     * The data_file_fetchers of this service.
     */
    override val dataFileFetchers: List<DataFileFetcher> by lazy {
        graphqlFieldFetchers.filterIsInstance<DataFileFetcher>()
    }
    /**
     * The data_files of this service.
     */
    override val dataFiles: List<DataFile> by lazy {
        dataFileFetchers.map{ it.dataFile }.distinct()
    }
    /**
     * The rest_api_fetchers of this service.
     */
    override val restApiFetchers: List<RestApiFetcher> by lazy {
        graphqlFieldFetchers.filterIsInstance<RestApiFetcher>()
    }
    /**
     * The configurations of this service.
     */
    override val configurations: List<ServiceConfiguration> by lazy {
        ( restResources.flatMap{ it.configurations } + graphqlTypes.flatMap{ it.configurations } )
        .map {
            it.definition
        }.distinct()
    }
    /**
     * Returns wether this instance is a service or not.
     */
    override val isaService: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllServices {
            return _context.get("services") as AllServices
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ServiceRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ServiceRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ServiceRecord(" +
            "name=$name" +
        ")"
    }
}
