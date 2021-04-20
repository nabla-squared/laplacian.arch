package laplacian.arch.backend.api.rest

import laplacian.arch.backend.api.rest.ArgumentAssignmentValue

import laplacian.util.*

/**
 * An entity describing a argument_assignment_value_fetcher_argument.
 */
interface ArgumentAssignmentValueFetcherArgument : ArgumentAssignmentValue {
    /**
     * The name of this argument_assignment_value_fetcher_argument.
     */
    val name: String
    /**
     * Returns wether this instance is a argument_assignment_value_fetcher_argument or not.
     */
    val isaArgumentAssignmentValueFetcherArgument: Boolean
}
