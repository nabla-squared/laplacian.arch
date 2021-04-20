package laplacian.arch.deployment.component.redis
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a redis_container_image.
 */
data class RedisContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RedisContainerImage, Record by _record {

    /**
     * The base_name of this redis_container_image.
     */
    override val baseName: String
        get() = getOrThrow("baseName") {
            "redis"
        }
    /**
     * Returns wether this instance is a redis_container_image or not.
     */
    override val isaRedisContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRedisContainerImages {
            return _context.get("redis_container_images") as AllRedisContainerImages
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RedisContainerImageRecord(record, _context)
    }
}
