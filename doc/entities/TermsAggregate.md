

# **TermsAggregate**
**namespace:** laplacian.arch.backend.api.elasticsearch.aggregate

A multi-bucket value source based aggregation where buckets are dynamically built
- one per unique value.




---

## Properties

### max_buckets: `String`
The number of term buckets should be returned (default: 10)


### variable_max_buckets: `Boolean`
Defines this terms_aggregate is variable_max_buckets or not.
- **Code:**
  ```kotlin
  maxBuckets?.contains("\${") ?: false
  ```

### sort_by_count: `String`
The sort order ('asc' or 'desc') in which the buckets will be returned


### variable_order: `Boolean`
Defines this terms_aggregate is variable_order or not.
- **Code:**
  ```kotlin
  sortByCount?.contains("\${") ?: false
  ```

### shard_size: `String`
The number of term buckets each shard will return to the coordinating node
(the node that coordinates the search execution)


### variable_shard_size: `Boolean`
Defines this terms_aggregate is variable_shard_size or not.
- **Code:**
  ```kotlin
  shardSize?.contains("\${") ?: false
  ```

### min_doc_count: `String`
the minimum document count required per term


### variable_min_doc_count: `Boolean`
Defines this terms_aggregate is variable_min_doc_count or not.
- **Code:**
  ```kotlin
  minDocCount?.contains("\${") ?: false
  ```

## Relationships
