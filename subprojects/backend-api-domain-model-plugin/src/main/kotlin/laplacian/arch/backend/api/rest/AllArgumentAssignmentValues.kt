package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All argument_assignment_values.
 */
class AllArgumentAssignmentValues(
    list: List<ArgumentAssignmentValue>,
    val context: Context
) : List<ArgumentAssignmentValue> by list {
}
