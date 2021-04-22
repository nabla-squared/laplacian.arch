

# **BucketSortAggregate**
**namespace:** laplacian.arch.backend.api.elasticsearch.aggregate

An entity describing a bucket_sort_aggregate.



---

## Properties

### from: `String`
Zero-based from index.


### variable_from: `Boolean`
Defines this bucket_sort_aggregate is variable_from or not.
- **Code:**
  ```kotlin
  from?.contains("\${") ?: false
  ```

### bucket_size: `String`
The size of the bucket_sort to be returned.


### variable_bucket_size: `Boolean`
Defines this bucket_sort_aggregate is variable_bucket_size or not.
- **Code:**
  ```kotlin
  bucketSize?.contains("\${") ?: false
  ```

## Relationships

### sorts: `List<FieldSort>`
The sorts of this bucket_sort_aggregate.
- **Cardinality:** `1..*`
