package laplacian.arch.deployment.component
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All components.
 */
class AllComponents(
    list: List<Component>,
    val context: Context
) : List<Component> by list {
}
