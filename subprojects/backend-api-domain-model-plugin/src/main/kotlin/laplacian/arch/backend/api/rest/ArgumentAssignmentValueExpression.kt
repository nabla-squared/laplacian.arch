package laplacian.arch.backend.api.rest

import laplacian.arch.backend.api.rest.ArgumentAssignmentValue

import laplacian.util.*

/**
 * An entity describing a argument_assignment_value_expression.
 */
interface ArgumentAssignmentValueExpression : ArgumentAssignmentValue {
    /**
     * The expression of this argument_assignment_value_expression.
     */
    val expression: String
    /**
     * Returns wether this instance is a argument_assignment_value_expression or not.
     */
    val isaArgumentAssignmentValueExpression: Boolean
}
