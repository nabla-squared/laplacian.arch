package laplacian.arch.deployment.component.redis


import laplacian.util.*

/**
 * An entity describing a redis_container_deployment.
 */
interface RedisContainerDeployment {
    /**
     * The port of this redis_container_deployment.
     */
    val port: Int
    /**
     * Returns wether this instance is a redis_container_deployment or not.
     */
    val isaRedisContainerDeployment: Boolean
}
