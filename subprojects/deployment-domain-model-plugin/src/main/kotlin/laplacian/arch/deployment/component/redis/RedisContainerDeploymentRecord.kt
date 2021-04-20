package laplacian.arch.deployment.component.redis
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a redis_container_deployment.
 */
data class RedisContainerDeploymentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RedisContainerDeployment, Record by _record {

    /**
     * The port of this redis_container_deployment.
     */
    override val port: Int
        get() = getOrThrow("port") {
            6379
        }
    /**
     * Returns wether this instance is a redis_container_deployment or not.
     */
    override val isaRedisContainerDeployment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRedisContainerDeployments {
            return _context.get("redis_container_deployments") as AllRedisContainerDeployments
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RedisContainerDeploymentRecord(record, _context)
    }
}
