

# **RestRequestParameter**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_request_parameter.



---

## Properties

### name: `String`
The name of this rest_request_parameter.
- **Attributes:** *PK*

### type: `String`
The type of this rest_request_parameter.

### multiple: `Boolean`
Defines this rest_request_parameter is multiple or not.
- **Default Value:**
  ```kotlin
  false
  ```

### value: `String`
The value of this rest_request_parameter.

### variable: `Boolean`
Defines this rest_request_parameter is variable or not.
- **Code:**
  ```kotlin
  value.contains("\${")
  ```

## Relationships
