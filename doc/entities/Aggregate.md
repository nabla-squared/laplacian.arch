

# **Aggregate**
**namespace:** laplacian.arch.backend.api.aggregate

An entity describing a aggregate.



---

## Properties

### name: `String`
The name of this aggregate.
- **Attributes:** *PK*

### namespace: `String`
The namespace of this aggregate.
- **Attributes:** *PK*

### depends_on_mybatis: `Boolean`
Defines this aggregate is depends_on_mybatis or not.
- **Code:**
  ```kotlin
  accessMethods.any{ it.type == "mybatis" }
  ```

### depends_on_elasticsearch: `Boolean`
Defines this aggregate is depends_on_elasticsearch or not.
- **Code:**
  ```kotlin
  accessMethods.any{ it.type == "elasticsearch" }
  ```

## Relationships

### root_entity: `Entity`
The root_entity of this aggregate.
- **Cardinality:** `1`

### access_methods: `List<AggregateAccessMethod>`
The access_methods of this aggregate.
- **Cardinality:** `*`
