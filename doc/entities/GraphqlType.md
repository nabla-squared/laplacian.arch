

# **GraphqlType**
**namespace:** laplacian.arch.backend.api.graphql

An entity describing a graphql_type.



---

## Properties

### name: `String`
The name of this graphql_type.
- **Attributes:** *PK*

### group: `String`
The group of this graphql_type.
- **Attributes:** *PK*

### description: `String`
The description of this graphql_type.
- **Default Value:**
  ```kotlin
  "A Graphql type representing ${name}"
  ```

### data_model_name: `String`
The data_model_name of this graphql_type.

### data_model_namespace: `String`
The data_model_namespace of this graphql_type.

### depends_on_mybatis: `Boolean`
Defines this graphql_type is depends_on_mybatis or not.
- **Code:**
  ```kotlin
  fields.any{ it.fetcher?.type == "mybatis" ?: false }
  ```

### fqn: `String`
The fqn of this graphql_type.
- **Code:**
  ```kotlin
  "${if (group != null) "${group!!.lowerUnderscorize()}." else ""}${name.lowerUnderscorize()}"
  ```

### graphql_type_name: `String`
The graphql_type_name of this graphql_type.
- **Code:**
  ```kotlin
  fqn.upperCamelize()
  ```

## Relationships

### data_model: `Entity?`
The data_model of this graphql_type.
- **Cardinality:** `0..1`

### fields: `List<GraphqlField>`
The fields of this graphql_type.
- **Cardinality:** `*`

### configurations: `List<ConfigurationBinding>`
The configurations of this graphql_type.
- **Cardinality:** `*`

### query_fields: `List<GraphqlField>`
The query_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  fields.filter{ it.operationType == "query" }
  ```

### root_query_fields: `List<GraphqlField>`
The root_query_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  queryFields.filter{ it.rootField }
  ```

### mutation_fields: `List<GraphqlField>`
The mutation_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  fields.filter{ it.operationType == "mutation" }
  ```

### root_mutation_fields: `List<GraphqlField>`
The root_mutation_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  mutationFields.filter{ it.rootField }
  ```

### subscription_fields: `List<GraphqlField>`
The subscription_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  fields.filter{ it.operationType == "subscription" }
  ```

### root_subscription_fields: `List<GraphqlField>`
The root_subscription_fields of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  subscriptionFields.filter{ it.rootField }
  ```

### referencing_graphql_types: `List<GraphqlType>`
The referencing_graphql_types of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  fields
  .filterIsInstance<GraphqlTypeReference>()
  .map{ it.referencingGraphqlType }
  .filter{ it != this }
  .distinct()
  ```

### mybatis_field_fetchers: `List<MybatisFetcher>`
The mybatis_field_fetchers of this graphql_type.
- **Cardinality:** `*`
- **Code:**
  ```kotlin
  fields
  .mapNotNull{ it.fetcher }
  .filterIsInstance<MybatisFetcher>()
  ```
