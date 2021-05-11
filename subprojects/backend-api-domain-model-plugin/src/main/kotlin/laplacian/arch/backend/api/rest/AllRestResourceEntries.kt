package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_resource_entries.
 */
class AllRestResourceEntries(
    list: List<RestResourceEntry>,
    val context: Context
) : List<RestResourceEntry> by list {
    val inNamespace: List<RestResourceEntry>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
