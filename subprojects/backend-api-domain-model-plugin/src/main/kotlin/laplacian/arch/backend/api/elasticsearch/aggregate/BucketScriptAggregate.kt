package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a bucket_script_aggregate.
 */
interface BucketScriptAggregate : ElasticsearchAggregate {
    /**
     * The script of this bucket_script_aggregate.
     */
    val script: String
    /**
     * The buckets_path of this bucket_script_aggregate.
     */
    val bucketsPath: List<BucketScriptPath>
    /**
     * Returns wether this instance is a bucket_script_aggregate or not.
     */
    val isaBucketScriptAggregate: Boolean
}
