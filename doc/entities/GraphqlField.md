

# **GraphqlField**
**namespace:** laplacian.arch.backend.api.graphql

An entity describing a graphql_field.



---

## Properties

### name: `String`
The name of this graphql_field.
- **Attributes:** *PK*

### description: `String`
The description of this graphql_field.
- **Default Value:**
  ```kotlin
  "The ${name} field."
  ```

### field_type: `String`
The field_type of this graphql_field.

### multiple: `Boolean`
Defines this graphql_field is multiple or not.
- **Default Value:**
  ```kotlin
  false
  ```

### optional: `Boolean`
Defines this graphql_field is optional or not.
- **Default Value:**
  ```kotlin
  false
  ```

### operation_type: `String`
The operation_type of this graphql_field.
- **Default Value:**
  ```kotlin
  "query"
  ```

### context_data_model_name: `String`
The context_data_model_name of this graphql_field.

### context_type: `String`
The context_type of this graphql_field.
- **Code:**
  ```kotlin
  when {
      rootField -> null
      (contextDataModelName == null) -> graphqlType.name
      else -> contextDataModelName
  }?.upperCamelize()
  ```

### record_type: `String`
The record_type of this graphql_field.
- **Code:**
  ```kotlin
  "Any"
  ```

### record_type_in_gql: `String`
The record_type_in_gql of this graphql_field.
- **Code:**
  ```kotlin
  recordType
  ```

### return_type: `String`
The return_type of this graphql_field.
- **Code:**
  ```kotlin
  if (multiple) "List<${recordType}>" else recordType
  ```

### return_type_in_gql: `String`
The return_type_in_gql of this graphql_field.
- **Code:**
  ```kotlin
  if (multiple) "[${recordTypeInGql}]" else recordTypeInGql
  ```

### root_field: `Boolean`
Specifies whether this field is shown in the root query object.

- **Default Value:**
  ```kotlin
  false
  ```

### fqn: `String`
The fqn of this graphql_field.
- **Code:**
  ```kotlin
  "${graphqlType.fqn}.${name.lowerUnderscorize()}"
  ```

## Relationships

### graphql_type: `GraphqlType`
The graphql_type of this graphql_field.
- **Cardinality:** `1`

### fetcher: `GraphqlFieldFetcher?`
The fetcher of this graphql_field.
- **Cardinality:** `0..1`

### arguments: `List<ApiCallArgument>`
The arguments of this graphql_field.
- **Cardinality:** `*`
