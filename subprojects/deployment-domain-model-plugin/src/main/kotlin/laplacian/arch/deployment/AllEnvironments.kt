package laplacian.arch.deployment
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.component.Component
import laplacian.arch.deployment.container.ContainerDeployment
import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.util.*

/**
 * All environments.
 */
class AllEnvironments(
    list: List<Environment>,
    val context: Context
) : List<Environment> by list {
}
