

# **RestApiFetcher**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_api_fetcher.



---

## Properties

### rest_resource_name: `String`
The rest_resource_name of this rest_api_fetcher.

### rest_operation_name: `String`
The rest_operation_name of this rest_api_fetcher.

## Relationships

### rest_resource: `RestResource`
The rest_resource of this rest_api_fetcher.
- **Cardinality:** `1`

### rest_operation: `RestOperation`
The rest_operation of this rest_api_fetcher.
- **Cardinality:** `1`
- **Code:**
  ```kotlin
  restResource.operations.find{ it.name == restOperationName }!!
  ```

### argument_assignments: `List<ArgumentAssignment>`
The argument_assignments of this rest_api_fetcher.
- **Cardinality:** `*`
