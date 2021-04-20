package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a avg_bucket_aggregate.
 */
interface AvgBucketAggregate : ElasticsearchAggregate {
    /**
     * The buckets_path of this avg_bucket_aggregate.
     */
    val bucketsPath: String
    /**
     * Returns wether this instance is a avg_bucket_aggregate or not.
     */
    val isaAvgBucketAggregate: Boolean
}
