package laplacian.arch.backend.api.cache

import laplacian.arch.backend.api.cache.CachePolicy

import laplacian.util.*

/**
 * An entity describing a redis_cache_policy.
 */
interface RedisCachePolicy : CachePolicy {
    /**
     * Returns wether this instance is a redis_cache_policy or not.
     */
    val isaRedisCachePolicy: Boolean
}
