package laplacian.arch.backend.api.elasticsearch.aggregate

import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregate

import laplacian.util.*

/**
 * An entity describing a bucket_sort_aggregate.
 */
interface BucketSortAggregate : ElasticsearchAggregate {
    /**
     * Zero-based from index.

     */
    val from: String?
    /**
     * Defines this bucket_sort_aggregate is variable_from or not.
     */
    val variableFrom: Boolean
    /**
     * The size of the bucket_sort to be returned.

     */
    val bucketSize: String?
    /**
     * Defines this bucket_sort_aggregate is variable_bucket_size or not.
     */
    val variableBucketSize: Boolean
    /**
     * The sorts of this bucket_sort_aggregate.
     */
    val sorts: List<FieldSort>
    /**
     * Returns wether this instance is a bucket_sort_aggregate or not.
     */
    val isaBucketSortAggregate: Boolean
}
