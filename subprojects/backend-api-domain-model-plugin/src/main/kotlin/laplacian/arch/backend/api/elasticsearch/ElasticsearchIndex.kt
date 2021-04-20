package laplacian.arch.backend.api.elasticsearch
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a elasticsearch_index.
 */
interface ElasticsearchIndex {
    /**
     * The name of this elasticsearch_index.
     */
    val name: String
    /**
     * The description of this elasticsearch_index.
     */
    val description: String
    /**
     * The document_model_name of this elasticsearch_index.
     */
    val documentModelName: String
    /**
     * The document_model of this elasticsearch_index.
     */
    val documentModel: Entity
    /**
     * The queries of this elasticsearch_index.
     */
    val queries: List<ElasticsearchQuery>
    /**
     * The default_sorts of this elasticsearch_index.
     */
    val defaultSorts: List<ElasticsearchIndexSort>
    /**
     * Returns wether this instance is a elasticsearch_index or not.
     */
    val isaElasticsearchIndex: Boolean
}
