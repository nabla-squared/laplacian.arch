

# **ApiCallArgument**
**namespace:** laplacian.arch.backend.api

An entity describing a api_call_argument.



---

## Properties

### name: `String`
The name of this api_call_argument.
- **Attributes:** *PK*

### type: `String`
The type of this api_call_argument.

### description: `String`
The description of this api_call_argument.
- **Default Value:**
  ```kotlin
  "${name}"
  ```

### required: `Boolean`
Defines this api_call_argument is required or not.
- **Default Value:**
  ```kotlin
  false
  ```

### multiple: `Boolean`
Defines this api_call_argument is multiple or not.
- **Default Value:**
  ```kotlin
  false
  ```

### nullable: `Boolean`
Defines this api_call_argument is nullable or not.
- **Code:**
  ```kotlin
  !multiple && !required && !containsKey("default_value")
  ```

### default_value: `String`
The default_value of this api_call_argument.
- **Default Value:**
  ```kotlin
  if (nullable) "null"
  else if (multiple) "emptyList()"
  else when(type) {
      "boolean" -> "false"
      "int" -> "0"
      "double" -> "0"
      "float" -> "0f"
      else -> "\"\""
  }
  ```

### class_name: `String`
The class_name of this api_call_argument.
- **Code:**
  ```kotlin
  when(type) {
      "boolean" -> "Boolean"
      "int" -> "Int"
      "float" -> "Float"
      else -> "String"
  }.let { if (multiple) "List<${it}>" else it }
  ```

### graphql_type: `String`
The graphql_type of this api_call_argument.
- **Code:**
  ```kotlin
  when(type) {
      "datetime" -> "DateTime"
      else -> type.upperCamelize()
  }.let { if (multiple) "[${it}!]" else it }
  ```

## Relationships
