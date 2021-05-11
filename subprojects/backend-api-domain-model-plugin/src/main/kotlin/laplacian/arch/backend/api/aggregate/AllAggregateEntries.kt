package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All aggregate_entries.
 */
class AllAggregateEntries(
    list: List<AggregateEntry>,
    val context: Context
) : List<AggregateEntry> by list {
    val inNamespace: List<AggregateEntry>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
