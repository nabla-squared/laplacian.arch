

# **GraphqlFieldLink**
**namespace:** laplacian.arch.backend.api.graphql

An entity describing a graphql_field_link.



---

## Properties

### type_name: `String`
The type_name of this graphql_field_link.

### group: `String`
The group of this graphql_field_link.
- **Default Value:**
  ```kotlin
  graphqlType.group
  ```

### field_name: `String`
The field_name of this graphql_field_link.

## Relationships

### linked_graphql_type: `GraphqlType`
The linked_graphql_type of this graphql_field_link.
- **Cardinality:** `1`

### linked_graphql_field: `GraphqlField`
The linked_graphql_field of this graphql_field_link.
- **Cardinality:** `1`
- **Code:**
  ```kotlin
  linkedGraphqlType.fields.find{ it.name == fieldName }!!
  ```
