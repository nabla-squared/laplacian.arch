package laplacian.arch.backend.api.cache
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.cache.CachePolicyRecord

import laplacian.generate.util.*
/**
 * An entity describing a redis_cache_policy.
 */
data class RedisCachePolicyRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): CachePolicyRecord(__record, _context), RedisCachePolicy {

    /**
     * Returns wether this instance is a redis_cache_policy or not.
     */
    override val isaRedisCachePolicy: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RedisCachePolicyRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RedisCachePolicyRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "RedisCachePolicyRecord(" +
            "name=$name" +
        ")"
    }
}
