package laplacian.arch.backend.api.cache
import laplacian.arch.backend.api.Duration
import laplacian.arch.backend.api.ConfigurationBinding


import laplacian.util.*

/**
 * An entity describing a cache_policy.
 */
interface CachePolicy {
    /**
     * The name of this cache_policy.
     */
    val name: String
    /**
     * The store_type of this cache_policy.
     */
    val storeType: String
    /**
     * Defines this cache_policy is ignore_error or not.
     */
    val ignoreError: Boolean
    /**
     * The key of this cache_policy.
     */
    val key: String
    /**
     * The expiration_time of this cache_policy.
     */
    val expirationTime: Duration?
    /**
     * The configurations of this cache_policy.
     */
    val configurations: List<ConfigurationBinding>
    /**
     * Returns wether this instance is a cache_policy or not.
     */
    val isaCachePolicy: Boolean
}
