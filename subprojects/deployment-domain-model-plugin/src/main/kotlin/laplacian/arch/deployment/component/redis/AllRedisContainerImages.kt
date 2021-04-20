package laplacian.arch.deployment.component.redis
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All redis_container_images.
 */
class AllRedisContainerImages(
    list: List<RedisContainerImage>,
    val context: Context
) : List<RedisContainerImage> by list {
}
