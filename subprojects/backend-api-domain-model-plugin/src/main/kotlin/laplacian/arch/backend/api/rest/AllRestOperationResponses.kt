package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_operation_responses.
 */
class AllRestOperationResponses(
    list: List<RestOperationResponse>,
    val context: Context
) : List<RestOperationResponse> by list {
}
