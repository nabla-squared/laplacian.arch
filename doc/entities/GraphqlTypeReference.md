

# **GraphqlTypeReference**
**namespace:** laplacian.arch.backend.api.graphql

An entity describing a graphql_type_reference.



---

## Properties

### graphql_type_name: `String`
The graphql_type_name of this graphql_type_reference.

### graphql_type_group: `String`
The graphql_type_group of this graphql_type_reference.
- **Default Value:**
  ```kotlin
  graphqlType.group
  ```

### record_type: `String`
The record_type of this graphql_type_reference.
- **Code:**
  ```kotlin
  referencingGraphqlType.name.upperCamelize()
  ```

### record_type_in_gql: `String`
The record_type_in_gql of this graphql_type_reference.
- **Code:**
  ```kotlin
  referencingGraphqlType.graphqlTypeName
  ```

## Relationships

### referencing_graphql_type: `GraphqlType`
The referencing_graphql_type of this graphql_type_reference.
- **Cardinality:** `1`
