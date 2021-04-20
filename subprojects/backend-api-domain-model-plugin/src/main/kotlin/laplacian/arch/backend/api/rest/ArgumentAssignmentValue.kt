package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a argument_assignment_value.
 */
interface ArgumentAssignmentValue {
    /**
     * The from of this argument_assignment_value.
     */
    val from: String
    /**
     * Returns wether this instance is a argument_assignment_value or not.
     */
    val isaArgumentAssignmentValue: Boolean
}
