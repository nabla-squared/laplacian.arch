package laplacian.arch.backend.api.cache
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.Duration
import laplacian.arch.backend.api.DurationRecord
import laplacian.arch.backend.api.ConfigurationBinding
import laplacian.arch.backend.api.ConfigurationBindingRecord


import laplacian.arch.backend.api.cache.HeapMemoryCachePolicyRecord
import laplacian.arch.backend.api.cache.RedisCachePolicyRecord

import laplacian.generate.util.*
/**
 * An entity describing a cache_policy.
 */
open class CachePolicyRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): CachePolicy, Record by _record {

    /**
     * The name of this cache_policy.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The store_type of this cache_policy.
     */
    override val storeType: String
        get() = getOrThrow("storeType")
    /**
     * Defines this cache_policy is ignore_error or not.
     */
    override val ignoreError: Boolean
        get() = getOrThrow("ignoreError") {
            true
        }
    /**
     * The key of this cache_policy.
     */
    override val key: String
        get() = "${storeType.lowerUnderscorize()}:${name.lowerUnderscorize()}"
    /**
     * The expiration_time of this cache_policy.
     */
    override val expirationTime: Duration? by lazy {
        getOrNull<Record>("expiration_time")?.let{ DurationRecord.from(it, _context) }
    }
    /**
     * The configurations of this cache_policy.
     */
    override val configurations: List<ConfigurationBinding> by lazy {
        ConfigurationBindingRecord.from(_record.getList("configurations", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a cache_policy or not.
     */
    override val isaCachePolicy: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllCachePolicies {
            return _context.get("cache_policies") as AllCachePolicies
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["store_type"]) {
                "heap" -> HeapMemoryCachePolicyRecord(record, _context)
                "redis" -> RedisCachePolicyRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined store_type $type. It is should be one of [heap, redis]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CachePolicyRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "CachePolicyRecord(" +
            "name=$name" +
        ")"
    }
}
