

# **RestOperation**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_operation.



---

## Properties

### method: `String`
The method of this rest_operation.

### path: `String`
The path of this rest_operation.

### name: `String`
The name of this rest_operation.
- **Attributes:** *PK*

### description: `String`
The description of this rest_operation.
- **Default Value:**
  ```kotlin
  "${method} ${path}"
  ```

### with_pagination: `Boolean`
Defines this rest_operation is with_pagination or not.
- **Default Value:**
  ```kotlin
  false
  ```

## Relationships

### rest_resource: `RestResource`
The rest_resource of this rest_operation.
- **Cardinality:** `1`

### path_parameters: `List<RestOperationParameter>`
The path_parameters of this rest_operation.
- **Cardinality:** `*`

### query_parameters: `List<RestOperationParameter>`
The query_parameters of this rest_operation.
- **Cardinality:** `*`

### http_headers: `List<RestOperationParameter>`
The http_headers of this rest_operation.
- **Cardinality:** `*`

### request_body: `RestOperationBodyDefinition?`
The request_body of this rest_operation.
- **Cardinality:** `0..1`

### response_body: `RestOperationBodyDefinition?`
The response_body of this rest_operation.
- **Cardinality:** `0..1`

### dependencies: `List<RestOperationDependency>`
The dependencies of this rest_operation.
- **Cardinality:** `*`

### usage_examples: `List<RestApiUsageExample>`
The usage_examples of this rest_operation.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  restResource.usageExamples.filter{ it.operationName == name }
  ```
