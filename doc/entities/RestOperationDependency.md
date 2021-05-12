

# **RestOperationDependency**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_operation_dependency.



---

## Properties

### type: `String`
The type of this rest_operation_dependency.

### aggregate_name: `String`
The aggregate_name of this rest_operation_dependency.

### aggregate_namespace: `String`
The aggregate_namespace of this rest_operation_dependency.

### method_name: `String`
The method_name of this rest_operation_dependency.

## Relationships

### aggregate: `Aggregate`
The aggregate of this rest_operation_dependency.
- **Cardinality:** `1`

### access_method: `AggregateAccessMethod`
The access_method of this rest_operation_dependency.
- **Cardinality:** `1`
- **Code:**
  ```kotlin
  aggregate.accessMethods.find{ it.name == methodName }!!
  ```

### response_mapping: `List<RestOperationResponseMapping>`
The response_mapping of this rest_operation_dependency.
- **Cardinality:** `*`
