package laplacian.arch.backend.api.cache

import laplacian.arch.backend.api.cache.CachePolicy

import laplacian.util.*

/**
 * An entity describing a heap_memory_cache_policy.
 */
interface HeapMemoryCachePolicy : CachePolicy {
    /**
     * Returns wether this instance is a heap_memory_cache_policy or not.
     */
    val isaHeapMemoryCachePolicy: Boolean
}
