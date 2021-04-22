

# **DataFile**
**namespace:** laplacian.arch.backend.api.data_file

An entity describing a data_file.



---

## Properties

### name: `String`
The name of this data_file.
- **Attributes:** *PK*

### description: `String`
The description of this data_file.
- **Default Value:**
  ```kotlin
  "Data file of ${name} in ${format}"
  ```

### format: `String`
The format of this data_file.
- **Default Value:**
  ```kotlin
  "json"
  ```

### default_path: `String`
The default_path of this data_file.
- **Default Value:**
  ```kotlin
  "./data/${name.lowerHyphenize()}.${format}"
  ```

## Relationships
