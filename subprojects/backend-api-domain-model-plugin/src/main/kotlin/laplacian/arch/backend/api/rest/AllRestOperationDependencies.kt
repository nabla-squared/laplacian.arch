package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.Aggregate
import laplacian.arch.backend.api.aggregate.AggregateAccessMethod

import laplacian.util.*

/**
 * All rest_operation_dependencies.
 */
class AllRestOperationDependencies(
    list: List<RestOperationDependency>,
    val context: Context
) : List<RestOperationDependency> by list {
}
