

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

### description: `String`
The description of this aggregate_access_method.
- **Default Value:**
  ```kotlin
  "${name}"
  ```

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

### record_model_namespace: `String`
The record_model_namespace of this aggregate_access_method.

### record_class_name: `String`
The record_class_name of this aggregate_access_method.
- **Code:**
  ```kotlin
  (recordModelName ?: aggregate.name).upperCamelize()
  ```

### result_class_name_in_java: `String`
The result_class_name_in_java of this aggregate_access_method.
- **Code:**
  ```kotlin
  if (multiple) "List<${recordClassName}>" else recordClassName
  ```

## Relationships

### aggregate: `Aggregate`
The aggregate of this aggregate_access_method.
- **Cardinality:** `1`

### arguments: `List<ApiCallArgument>`
The arguments of this aggregate_access_method.
- **Cardinality:** `*`

### record_model: `Entity?`
The record_model of this aggregate_access_method.
- **Cardinality:** `0..1`
