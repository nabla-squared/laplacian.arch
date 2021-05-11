

# **ElasticsearchAccessMethod**
**namespace:** laplacian.arch.backend.api.aggregate

An entity describing a elasticsearch_access_method.



---

## Properties

### elasticsearch_client_name: `String`
The elasticsearch_client_name of this elasticsearch_access_method.

### index_name: `String`
The index_name of this elasticsearch_access_method.
- **Default Value:**
  ```kotlin
  aggregate.rootEntity.tableName
  ```

### offset: `String`
From index to start the search from.

- **Default Value:**
  ```kotlin
  "0"
  ```

### limit: `String`
The maximum number of search hits to return.

- **Default Value:**
  ```kotlin
  "10"
  ```

## Relationships

### query: `ElasticsearchQueryPredicate`
The query of this elasticsearch_access_method.
- **Cardinality:** `1`

### collapse: `ElasticsearchQueryCollapse?`
Field collapsing on search request.

- **Cardinality:** `0..1`

### sort: `List<ElasticsearchQuerySort>`
The sort of this elasticsearch_access_method.
- **Cardinality:** `*`
