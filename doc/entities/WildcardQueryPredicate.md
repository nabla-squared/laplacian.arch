

# **WildcardQueryPredicate**
**namespace:** laplacian.arch.backend.api.elasticsearch.query

The wildcard search query. Supported wildcards are *, which matches any character sequence
(including the empty one), and ?, which matches any single character. Note this query can be slow,
as it needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
a Wildcard term should not start with one of the wildcards * or ?.
(The wildcard field type however, is optimized for leading wildcards)




---

## Properties

### field: `String`
Field you wish to search.


### value: `String`
Wildcard pattern for terms you wish to find.


### boost: `Double`
Floating point number used to decrease or increase the relevance scores of a query.


### case_insensitive: `Boolean`
Allows ASCII case insensitive matching of the value with the indexed field values when set to true.
Default is false which means the case sensitivity of matching depends on the underlying field’s mapping.


### rewrite: `String`
The rewrite of this wildcard_query_predicate.

## Relationships
