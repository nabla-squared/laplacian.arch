

# **RestResource**
**namespace:** laplacian.arch.backend.api.rest

An entity describing a rest_resource.



---

## Properties

### name: `String`
The name of this rest_resource.
- **Attributes:** *PK*

### namespace: `String`
The namespace of this rest_resource.
- **Attributes:** *PK*

### path: `String`
The path of this rest_resource.

### description: `String`
The description of this rest_resource.
- **Default Value:**
  ```kotlin
  "${name}"
  ```

### resource_model_name: `String`
The resource_model_name of this rest_resource.

## Relationships

### operations: `List<RestOperation>`
The operations of this rest_resource.
- **Cardinality:** `1..*`

### configurations: `List<ConfigurationBinding>`
The configurations of this rest_resource.
- **Cardinality:** `*`
