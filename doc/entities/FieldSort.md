

# **FieldSort**
**namespace:** laplacian.arch.backend.api.elasticsearch.aggregate

An entity describing a field_sort.



---

## Properties

### field: `String`
The field of this field_sort.
- **Attributes:** *PK*

### order: `String`
The order of this field_sort.

### variable_order: `Boolean`
Defines this field_sort is variable_order or not.
- **Code:**
  ```kotlin
  order?.contains("\${") ?: false
  ```

## Relationships
