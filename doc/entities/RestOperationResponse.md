

# **RestOperationResponse**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_operation_response.



---

## Properties

### type: `String`
The type of this rest_operation_response.

### optional: `Boolean`
Defines this rest_operation_response is optional or not.
- **Default Value:**
  ```kotlin
  false
  ```

### multiple: `Boolean`
Defines this rest_operation_response is multiple or not.
- **Default Value:**
  ```kotlin
  false
  ```

### type_in_java: `String`
The type_in_java of this rest_operation_response.
- **Code:**
  ```kotlin
  when(type) {
      "number" -> "Int"
      "object" -> "Map<String, Any?>"
      "array" -> "List<Any>"
      else -> type.upperCamelize()
  }.let {
      (if (multiple) "List<$it>" else it) + (if (optional) "?" else "")
  }
  ```

## Relationships
