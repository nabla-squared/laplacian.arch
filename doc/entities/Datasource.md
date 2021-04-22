

# **Datasource**
**namespace:** laplacian.arch.backend.api.datasource

A *DataSource* represents an interface through which a client application access to a data store.
This includes the following models.
- The entity that the datastore exposes to the client
- Statement issued by the client to the datastore




---

## Properties

### name: `String`
The name of this datasource.
- **Attributes:** *PK*

### description: `String`
The description of this datasource.
- **Default Value:**
  ```kotlin
  name
  ```

### db_type: `String`
The db_type of this datasource.

### non_blocking: `Boolean`
Defines this datasource is non_blocking or not.

## Relationships
