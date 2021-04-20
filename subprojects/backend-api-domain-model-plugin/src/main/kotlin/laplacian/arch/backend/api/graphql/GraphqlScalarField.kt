package laplacian.arch.backend.api.graphql

import laplacian.arch.backend.api.graphql.GraphqlField

import laplacian.util.*

/**
 * An entity describing a graphql_scalar_field.
 */
interface GraphqlScalarField : GraphqlField {
    /**
     * The value_type of this graphql_scalar_field.
     */
    val valueType: String
    /**
     * Returns wether this instance is a graphql_scalar_field or not.
     */
    val isaGraphqlScalarField: Boolean
}
