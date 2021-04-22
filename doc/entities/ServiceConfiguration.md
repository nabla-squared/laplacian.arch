

# **ServiceConfiguration**
**namespace:** laplacian.arch.backend.api

An entity describing a service_configuration.



---

## Properties

### name: `String`
The name of this service_configuration.
- **Attributes:** *PK*

### category: `String`
The category of this service_configuration.
- **Attributes:** *PK*

### type: `String`
The type of this service_configuration.

### key: `String`
The key of this service_configuration.
- **Code:**
  ```kotlin
  "${category}.${name}"
  ```

### default_value: `String`
The default_value of this service_configuration.

### environment_variable_name: `String`
The environment_variable_name of this service_configuration.
- **Default Value:**
  ```kotlin
  "${key.upperUnderscorize()}"
  ```

## Relationships
