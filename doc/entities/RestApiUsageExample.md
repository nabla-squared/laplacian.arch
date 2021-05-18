

# **RestApiUsageExample**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_api_usage_example.



---

## Properties

### rest_resource_name: `String`
The rest_resource_name of this rest_api_usage_example.

### namespace: `String`
The namespace of this rest_api_usage_example.

### operation_name: `String`
The operation_name of this rest_api_usage_example.

### tags: `List<String>`
The tags of this rest_api_usage_example.

### usage: `String`
The usage of this rest_api_usage_example.
- **Default Value:**
  ```kotlin
  "${operation.method.lowerCamelize()} ${operation.path.spaceDelimited()} of a ${restResourceName.spaceDelimited()}".capitalizeFirst()
  ```

### curl: `String`
The curl of this rest_api_usage_example.

### queryParameters: `String`
The queryParameters of this rest_api_usage_example.
- **Code:**
  ```kotlin
  """\?(.*)'""".toRegex().find(curl)?.groupValues?.get(1) ?: ""
  ```

### request_body_json: `String`
The request_body_json of this rest_api_usage_example.
- **Code:**
  ```kotlin
  """-d\s+'([\s\S]*)'""".toRegex().find(curl)?.groupValues?.get(1) ?: ""
  ```

### status_code: `Int`
The status_code of this rest_api_usage_example.

### response_body_json: `String`
The response_body_json of this rest_api_usage_example.

## Relationships

### rest_resource: `RestResource`
The rest_resource of this rest_api_usage_example.
- **Cardinality:** `1`

### operation: `RestOperation`
The operation of this rest_api_usage_example.
- **Cardinality:** `1`
- **Code:**
  ```kotlin
  restResource.operations.find{ it.name == operationName }!!
  ```
