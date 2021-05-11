package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_operation_parameters.
 */
class AllRestOperationParameters(
    list: List<RestOperationParameter>,
    val context: Context
) : List<RestOperationParameter> by list {
}
