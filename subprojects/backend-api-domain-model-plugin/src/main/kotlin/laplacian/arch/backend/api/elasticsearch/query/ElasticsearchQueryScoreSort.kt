package laplacian.arch.backend.api.elasticsearch.query

import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySort

import laplacian.util.*

/**
 * An entity describing a elasticsearch_query_score_sort.
 */
interface ElasticsearchQueryScoreSort : ElasticsearchQuerySort {
    /**
     * Returns wether this instance is a elasticsearch_query_score_sort or not.
     */
    val isaElasticsearchQueryScoreSort: Boolean
}
