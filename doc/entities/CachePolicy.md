

# **CachePolicy**
**namespace:** laplacian.arch.backend.api.cache

An entity describing a cache_policy.



---

## Properties

### name: `String`
The name of this cache_policy.
- **Attributes:** *PK*

### store_type: `String`
The store_type of this cache_policy.

### ignore_error: `Boolean`
Defines this cache_policy is ignore_error or not.
- **Default Value:**
  ```kotlin
  true
  ```

### key: `String`
The key of this cache_policy.
- **Code:**
  ```kotlin
  "${storeType.lowerUnderscorize()}:${name.lowerUnderscorize()}"
  ```

## Relationships

### expiration_time: `Duration?`
The expiration_time of this cache_policy.
- **Cardinality:** `0..1`

### configurations: `List<ConfigurationBinding>`
The configurations of this cache_policy.
- **Cardinality:** `*`
