

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

## Relationships

### arguments: `List<ApiCallArgument>`
The arguments of this rest_operation.
- **Cardinality:** `*`

### path_parameters: `List<RestRequestParameter>`
The path_parameters of this rest_operation.
- **Cardinality:** `*`

### query_parameters: `List<RestRequestParameter>`
The query_parameters of this rest_operation.
- **Cardinality:** `*`

### http_headers: `List<RestRequestParameter>`
The http_headers of this rest_operation.
- **Cardinality:** `*`

### rest_resource: `RestResource`
The rest_resource of this rest_operation.
- **Cardinality:** `1`

### response: `RestOperationResponse`
The response of this rest_operation.
- **Cardinality:** `1`
