package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a argument_assignment.
 */
interface ArgumentAssignment {
    /**
     * The key of this argument_assignment.
     */
    val key: String
    /**
     * The value of this argument_assignment.
     */
    val value: ArgumentAssignmentValue
    /**
     * Returns wether this instance is a argument_assignment or not.
     */
    val isaArgumentAssignment: Boolean
}
