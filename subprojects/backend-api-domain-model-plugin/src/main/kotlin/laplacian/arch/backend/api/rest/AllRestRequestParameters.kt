package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_request_parameters.
 */
class AllRestRequestParameters(
    list: List<RestRequestParameter>,
    val context: Context
) : List<RestRequestParameter> by list {
}
