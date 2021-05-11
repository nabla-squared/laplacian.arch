

# **Service**
**namespace:** laplacian.arch.backend.api

An entity describing a service.



---

## Properties

### name: `String`
The name of this service.
- **Attributes:** *PK*

### namespace: `String`
The namespace of this service.

### version: `String`
The version of this service.

### description: `String`
The description of this service.
- **Default Value:**
  ```kotlin
  name
  ```

### graphql_type_groups: `List<String>`
The graphql_type_groups of this service.
- **Code:**
  ```kotlin
  graphqlTypes.map{ it.group }.filterNotNull().distinct()
  ```

### depends_on_elasticsearch: `Boolean`
Defines this service is depends_on_elasticsearch or not.
- **Code:**
  ```kotlin
  elasticsearchIndexes.isNotEmpty() || aggregates.any{ it.dependsOnElasticsearch }
  ```

### depends_on_cache: `Boolean`
Defines this service is depends_on_cache or not.
- **Code:**
  ```kotlin
  cachePolicies.isNotEmpty()
  ```

### depends_on_data_file: `Boolean`
Defines this service is depends_on_data_file or not.
- **Code:**
  ```kotlin
  dataFiles.isNotEmpty()
  ```

### depends_on_redis_cache: `Boolean`
Defines this service is depends_on_redis_cache or not.
- **Code:**
  ```kotlin
  redisCachePolicies.isNotEmpty()
  ```

### depends_on_mybatis: `Boolean`
Defines this service is depends_on_mybatis or not.
- **Code:**
  ```kotlin
  graphqlTypes.any{ it.dependsOnMybatis } || aggregates.any{ it.dependsOnMybatis }
  ```

### depends_on_blocking_postgres_datasource: `Boolean`
Defines this service is depends_on_blocking_postgres_datasource or not.
- **Code:**
  ```kotlin
  blockingDatasources.any { it.dbType == "postgres" }
  ```

### depends_on_blocking_mysql_datasource: `Boolean`
Defines this service is depends_on_blocking_mysql_datasource or not.
- **Code:**
  ```kotlin
  blockingDatasources.any { it.dbType == "mysql" }
  ```

### depends_on_blocking_oracle_datasource: `Boolean`
Defines this service is depends_on_blocking_oracle_datasource or not.
- **Code:**
  ```kotlin
  blockingDatasources.any { it.dbType == "oracle" }
  ```

### has_custom_logic: `Boolean`
Defines this service is has_custom_logic or not.
- **Code:**
  ```kotlin
  graphqlFieldFetchers.any{ it.type == "custom" }
  ```

### instrumentations: `List<String>`
The instrumentations of this service.

## Relationships

### aggregate_entries: `List<AggregateEntry>`
The aggregate_entries of this service.
- **Cardinality:** `*`

### aggregates: `List<Aggregate>`
The aggregates of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  aggregateEntries.map{ it.aggregate }
  ```

### rest_resource_entries: `List<RestResourceEntry>`
The rest_resource_entries of this service.
- **Cardinality:** `*`

### rest_resources: `List<RestResource>`
The rest_resources of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  restResourceEntries.map{ it.restResource }
  ```

### datasource_entries: `List<DatasourceEntry>`
The datasource_entries of this service.
- **Cardinality:** `*`

### datasources: `List<Datasource>`
The datasources of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  datasourceEntries.map{ it.datasource }.distinct()
  ```

### primary_datasource: `Datasource?`
The primary_datasource of this service.
- **Cardinality:** `0..1`
- **Code:**
  ```kotlin
  datasourceEntries.find{ it.primary }?.datasource
  ```

### blocking_datasources: `List<Datasource>`
The blocking_datasources of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  datasources.filter{ !it.nonBlocking }
  ```

### non_blocking_datasources: `List<Datasource>`
The non_blocking_datasources of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  datasources.filter{ it.nonBlocking }
  ```

### elasticsearch_clients: `List<ElasticsearchClient>`
The elasticsearch_clients of this service.
- **Cardinality:** `*`

### primary_elasticsearch_client: `ElasticsearchClient?`
The primary_elasticsearch_client of this service.
- **Cardinality:** `0..1`
- **Code:**
  ```kotlin
  elasticsearchClients.find{ it.primary }
  ```

### graphql_type_entries: `List<GraphqlTypeEntry>`
The graphql_type_entries of this service.
- **Cardinality:** `*`

### graphql_types: `List<GraphqlType>`
The graphql_types of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlTypeEntries.map{ it.graphqlType }.distinct()
  ```

### root_graphql_types: `List<GraphqlType>`
The root_graphql_types of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlTypes.filter{ it.group == null }
  ```

### elasticsearch_indexes: `List<ElasticsearchIndex>`
The elasticsearch_indexes of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  listOf<ElasticsearchIndex>()
  ```

### graphql_fields: `List<GraphqlField>`
The graphql_fields of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlTypes
  .flatMap{ it.fields ?: emptyList() }
  ```

### graphql_field_fetchers: `List<GraphqlFieldFetcher>`
The graphql_field_fetchers of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlFields.map{ it.fetcher }.filterNotNull()
  ```

### cache_policies: `List<CachePolicy>`
The cache_policies of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlFieldFetchers.map{ it.cachePolicy }.filterNotNull()
  ```

### redis_cache_policies: `List<RedisCachePolicy>`
The redis_cache_policies of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  cachePolicies.filterIsInstance<RedisCachePolicy>()
  ```

### data_file_fetchers: `List<DataFileFetcher>`
The data_file_fetchers of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlFieldFetchers.filterIsInstance<DataFileFetcher>()
  ```

### data_files: `List<DataFile>`
The data_files of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  dataFileFetchers.map{ it.dataFile }.distinct()
  ```

### rest_api_fetchers: `List<RestApiFetcher>`
The rest_api_fetchers of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  graphqlFieldFetchers.filterIsInstance<RestApiFetcher>()
  ```

### configurations: `List<ServiceConfiguration>`
The configurations of this service.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  ( restResources.flatMap{ it.configurations } + graphqlTypes.flatMap{ it.configurations } )
  .map {
      it.definition
  }.distinct()
  ```
