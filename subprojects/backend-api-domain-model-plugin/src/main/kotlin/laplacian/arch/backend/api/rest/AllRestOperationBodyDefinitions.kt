package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_operation_body_definitions.
 */
class AllRestOperationBodyDefinitions(
    list: List<RestOperationBodyDefinition>,
    val context: Context
) : List<RestOperationBodyDefinition> by list {
}
