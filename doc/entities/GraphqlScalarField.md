

# **GraphqlScalarField**
**namespace:** laplacian.arch.backend.api.graphql

An entity describing a graphql_scalar_field.



---

## Properties

### value_type: `String`
The value_type of this graphql_scalar_field.

### record_type: `String`
The record_type of this graphql_scalar_field.
- **Code:**
  ```kotlin
  when (valueType) {
      "string" -> "String"
      "int" -> "Int"
      "float" -> "Float"
      else -> "Any"
  }
  ```

## Relationships
