package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.ConfigurationBinding

import laplacian.util.*

/**
 * All rest_resources.
 */
class AllRestResources(
    list: List<RestResource>,
    val context: Context
) : List<RestResource> by list {
    val inNamespace: List<RestResource>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
