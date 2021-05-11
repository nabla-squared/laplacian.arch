

# **ElasticsearchQuerySort**
**namespace:** laplacian.arch.backend.api.elasticsearch.query

An entity describing a elasticsearch_query_sort.



---

## Properties

### type: `String`
The type of this elasticsearch_query_sort.
- **Attributes:** *PK*
- **Default Value:**
  ```kotlin
  "field"
  ```

### order: `String`
The order of this elasticsearch_query_sort.
- **Default Value:**
  ```kotlin
  "desc"
  ```

### variable_order: `Boolean`
Defines this elasticsearch_query_sort is variable_order or not.
- **Code:**
  ```kotlin
  order?.contains("\${") ?: false
  ```

## Relationships
