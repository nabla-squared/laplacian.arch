package laplacian.arch.backend.api.graphql

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.util.*

/**
 * An entity describing a graphql_field_link.
 */
interface GraphqlFieldLink : GraphqlFieldFetcher {
    /**
     * The type_name of this graphql_field_link.
     */
    val typeName: String
    /**
     * The group of this graphql_field_link.
     */
    val group: String
    /**
     * The field_name of this graphql_field_link.
     */
    val fieldName: String
    /**
     * The linked_graphql_type of this graphql_field_link.
     */
    val linkedGraphqlType: GraphqlType
    /**
     * The linked_graphql_field of this graphql_field_link.
     */
    val linkedGraphqlField: GraphqlField
    /**
     * Returns wether this instance is a graphql_field_link or not.
     */
    val isaGraphqlFieldLink: Boolean
}
