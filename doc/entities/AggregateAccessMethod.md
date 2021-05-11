

# **AggregateAccessMethod**
**namespace:** laplacian.arch.backend.api.aggregate

An entity describing a aggregate_access_method.



---

## Properties

### name: `String`
The name of this aggregate_access_method.
- **Attributes:** *PK*

### type: `String`
The type of this aggregate_access_method.

### multiple: `Boolean`
Defines this aggregate_access_method is multiple or not.
- **Default Value:**
  ```kotlin
  true
  ```

### with_pagination: `Boolean`
Defines this aggregate_access_method is with_pagination or not.
- **Default Value:**
  ```kotlin
  false
  ```

### record_model_name: `String`
The record_model_name of this aggregate_access_method.
- **Default Value:**
  ```kotlin
  aggregate.rootEntity.name
  ```

### record_model_namespace: `String`
The record_model_namespace of this aggregate_access_method.
- **Default Value:**
  ```kotlin
  aggregate.rootEntity.namespace
  ```

## Relationships

### aggregate: `Aggregate`
The aggregate of this aggregate_access_method.
- **Cardinality:** `1`

### arguments: `List<ApiCallArgument>`
The arguments of this aggregate_access_method.
- **Cardinality:** `*`

### record_model: `Entity`
The record_model of this aggregate_access_method.
- **Cardinality:** `1`
