package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All argument_assignments.
 */
class AllArgumentAssignments(
    list: List<ArgumentAssignment>,
    val context: Context
) : List<ArgumentAssignment> by list {
}
