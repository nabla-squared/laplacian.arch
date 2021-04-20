package laplacian.arch.deployment.component.redis
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All redis_container_deployments.
 */
class AllRedisContainerDeployments(
    list: List<RedisContainerDeployment>,
    val context: Context
) : List<RedisContainerDeployment> by list {
}
