

# **RestOperationParameter**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_operation_parameter.



---

## Properties

### name: `String`
The name of this rest_operation_parameter.
- **Attributes:** *PK*

### description: `String`
The description of this rest_operation_parameter.
- **Default Value:**
  ```kotlin
  "$name"
  ```

### required: `Boolean`
Defines this rest_operation_parameter is required or not.
- **Default Value:**
  ```kotlin
  false
  ```

### type: `String`
The type of this rest_operation_parameter.

### multiple: `Boolean`
Defines this rest_operation_parameter is multiple or not.
- **Default Value:**
  ```kotlin
  false
  ```

### type_in_java: `String`
The type_in_java of this rest_operation_parameter.
- **Code:**
  ```kotlin
  when (type) {
    "string" -> "String"
    "number" -> "Integer"
    "float" -> "Double"
    "boolean" -> "boolean"
    "object" -> "Map<String, Object>"
    else -> throw IllegalArgumentException("Can not handle type: $type")
  }
  ```

## Relationships
