package laplacian.arch.backend.api.graphql

import laplacian.arch.backend.api.graphql.GraphqlField

import laplacian.util.*

/**
 * An entity describing a graphql_type_reference.
 */
interface GraphqlTypeReference : GraphqlField {
    /**
     * The graphql_type_name of this graphql_type_reference.
     */
    val graphqlTypeName: String
    /**
     * The graphql_type_group of this graphql_type_reference.
     */
    val graphqlTypeGroup: String
    /**
     * The referencing_graphql_type of this graphql_type_reference.
     */
    val referencingGraphqlType: GraphqlType
    /**
     * Returns wether this instance is a graphql_type_reference or not.
     */
    val isaGraphqlTypeReference: Boolean
}
