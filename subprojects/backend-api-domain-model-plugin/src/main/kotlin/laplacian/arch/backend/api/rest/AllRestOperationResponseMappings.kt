package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_operation_response_mappings.
 */
class AllRestOperationResponseMappings(
    list: List<RestOperationResponseMapping>,
    val context: Context
) : List<RestOperationResponseMapping> by list {
}
