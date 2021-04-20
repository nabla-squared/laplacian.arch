package laplacian.arch.backend.api.rest

import laplacian.arch.backend.api.rest.ArgumentAssignmentValue

import laplacian.util.*

/**
 * An entity describing a argument_assignment_value_graphql_type_config.
 */
interface ArgumentAssignmentValueGraphqlTypeConfig : ArgumentAssignmentValue {
    /**
     * The name of this argument_assignment_value_graphql_type_config.
     */
    val name: String
    /**
     * Returns wether this instance is a argument_assignment_value_graphql_type_config or not.
     */
    val isaArgumentAssignmentValueGraphqlTypeConfig: Boolean
}
