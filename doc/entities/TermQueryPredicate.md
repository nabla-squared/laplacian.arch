

# **TermQueryPredicate**
**namespace:** laplacian.arch.backend.api.elasticsearch.query

An entity describing a term_query_predicate.



---

## Properties

### field: `String`
Field you wish to search.


### value: `String`
Term you wish to find in the provided <field>. To return a document,
the term must exactly match the field value, including whitespace and capitalization.


### boost: `Double`
Floating point number used to decrease or increase the relevance scores of a query.


### case_insensitive: `Boolean`
Allows ASCII case insensitive matching of the value with the indexed field values when set to true.
Default is false which means the case sensitivity of matching depends on the underlying field’s mapping.


## Relationships
