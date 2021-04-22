

# **ElasticSearchClient**
**namespace:** laplacian.arch.backend.api

An entity describing a elastic_search_client.



---

## Properties

### name: `String`
The name of this elastic_search_client.

### is_default: `Boolean`
Defines this elastic_search_client is is_default or not.
- **Default Value:**
  ```kotlin
  false
  ```

### configuration_category: `String`
The configuration_category of this elastic_search_client.
- **Default Value:**
  ```kotlin
  name.lowerHyphenize()
  ```

### configuration_name_of_endpoints: `String`
The configuration_name_of_endpoints of this elastic_search_client.
- **Default Value:**
  ```kotlin
  "endpoints"
  ```

### configuration_name_of_path_prefix: `String`
The configuration_name_of_path_prefix of this elastic_search_client.
- **Default Value:**
  ```kotlin
  "path-prefix"
  ```

### configuration_name_of_connect_timeout: `String`
The configuration_name_of_connect_timeout of this elastic_search_client.
- **Default Value:**
  ```kotlin
  "connect-timeout"
  ```

### configuration_name_of_socket_timeout: `String`
The configuration_name_of_socket_timeout of this elastic_search_client.
- **Default Value:**
  ```kotlin
  "socket-timeout"
  ```

### configuration_name_of_max_in_memory_size: `String`
The configuration_name_of_max_in_memory_size of this elastic_search_client.
- **Default Value:**
  ```kotlin
  "max-in-memory-size"
  ```

## Relationships

### configurations: `List<ServiceConfiguration>`
The configurations of this elastic_search_client.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  listOf(
      endpoints,
      pathPrefix,
      connectTimeout,
      socketTimeout,
      maxInMemorySize
  )
  .filterNotNull()
  ```

### endpoints: `ServiceConfiguration`
The endpoints of this elastic_search_client.
- **Cardinality:** `1`

### path_prefix: `ServiceConfiguration?`
The path_prefix of this elastic_search_client.
- **Cardinality:** `0..1`

### connect_timeout: `ServiceConfiguration?`
The connect_timeout of this elastic_search_client.
- **Cardinality:** `0..1`

### socket_timeout: `ServiceConfiguration?`
The socket_timeout of this elastic_search_client.
- **Cardinality:** `0..1`

### max_in_memory_size: `ServiceConfiguration?`
The max_in_memory_size of this elastic_search_client.
- **Cardinality:** `0..1`
