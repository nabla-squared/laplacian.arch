package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * A multi-bucket value source based aggregation where buckets are dynamically built
- one per unique value.

 */
interface TermsAggregate : ElasticsearchAggregate {
    /**
     * The number of term buckets should be returned (default: 10)

     */
    val maxBuckets: String?
    /**
     * Defines this terms_aggregate is variable_max_buckets or not.
     */
    val variableMaxBuckets: Boolean
    /**
     * The sort order ('asc' or 'desc') in which the buckets will be returned

     */
    val sortByCount: String?
    /**
     * Defines this terms_aggregate is variable_order or not.
     */
    val variableOrder: Boolean
    /**
     * The number of term buckets each shard will return to the coordinating node
(the node that coordinates the search execution)

     */
    val shardSize: String?
    /**
     * Defines this terms_aggregate is variable_shard_size or not.
     */
    val variableShardSize: Boolean
    /**
     * the minimum document count required per term

     */
    val minDocCount: String?
    /**
     * Defines this terms_aggregate is variable_min_doc_count or not.
     */
    val variableMinDocCount: Boolean
    /**
     * Returns wether this instance is a terms_aggregate or not.
     */
    val isaTermsAggregate: Boolean
}
