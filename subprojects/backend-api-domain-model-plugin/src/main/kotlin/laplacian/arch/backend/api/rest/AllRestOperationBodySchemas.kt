package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity

import laplacian.util.*

/**
 * All rest_operation_body_schemas.
 */
class AllRestOperationBodySchemas(
    list: List<RestOperationBodySchema>,
    val context: Context
) : List<RestOperationBodySchema> by list {
    val inNamespace: List<RestOperationBodySchema>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
