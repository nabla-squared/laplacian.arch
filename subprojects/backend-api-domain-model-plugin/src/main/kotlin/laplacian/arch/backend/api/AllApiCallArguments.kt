package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All api_call_arguments.
 */
class AllApiCallArguments(
    list: List<ApiCallArgument>,
    val context: Context
) : List<ApiCallArgument> by list {
}
