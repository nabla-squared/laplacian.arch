package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity

import laplacian.util.*

/**
 * All aggregates.
 */
class AllAggregates(
    list: List<Aggregate>,
    val context: Context
) : List<Aggregate> by list {
    val inNamespace: List<Aggregate>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
