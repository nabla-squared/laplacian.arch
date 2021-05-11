

# **DatasourceEntry**
**namespace:** laplacian.arch.backend.api

An entity describing a datasource_entry.



---

## Properties

### name: `String`
The name of this datasource_entry.
- **Attributes:** *PK*

### primary: `Boolean`
Defines this datasource_entry is primary or not.
- **Default Value:**
  ```kotlin
  false
  ```

## Relationships

### datasource: `Datasource`
The datasource of this datasource_entry.
- **Cardinality:** `1`
