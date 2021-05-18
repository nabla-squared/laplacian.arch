package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All rest_api_usage_examples.
 */
class AllRestApiUsageExamples(
    list: List<RestApiUsageExample>,
    val context: Context
) : List<RestApiUsageExample> by list {
    val inNamespace: List<RestApiUsageExample>
        get() = filter {
            it.namespace.startsWith(context.get("project.namespace") as String)
        }
}
