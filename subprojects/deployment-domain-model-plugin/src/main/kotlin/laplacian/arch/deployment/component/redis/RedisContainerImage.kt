package laplacian.arch.deployment.component.redis


import laplacian.util.*

/**
 * An entity describing a redis_container_image.
 */
interface RedisContainerImage {
    /**
     * The base_name of this redis_container_image.
     */
    val baseName: String
    /**
     * Returns wether this instance is a redis_container_image or not.
     */
    val isaRedisContainerImage: Boolean
}
