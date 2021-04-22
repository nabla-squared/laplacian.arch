

# **ElasticsearchIndex**
**namespace:** laplacian.arch.backend.api.elasticsearch

An entity describing a elasticsearch_index.



---

## Properties

### name: `String`
The name of this elasticsearch_index.
- **Attributes:** *PK*

### description: `String`
The description of this elasticsearch_index.
- **Default Value:**
  ```kotlin
  "elasticsearch index schema of ${name}"
  ```

### document_model_name: `String`
The document_model_name of this elasticsearch_index.

## Relationships

### document_model: `Entity`
The document_model of this elasticsearch_index.
- **Cardinality:** `1`

### queries: `List<ElasticsearchQuery>`
The queries of this elasticsearch_index.
- **Cardinality:** `*`

### default_sorts: `List<ElasticsearchIndexSort>`
The default_sorts of this elasticsearch_index.
- **Cardinality:** `*`
