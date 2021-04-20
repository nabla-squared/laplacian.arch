package laplacian.arch.backend.api
import laplacian.arch.backend.api.graphql.GraphqlType


import laplacian.util.*

/**
 * An entity describing a graphql_type_entry.
 */
interface GraphqlTypeEntry {
    /**
     * The name of this graphql_type_entry.
     */
    val name: String
    /**
     * The group of this graphql_type_entry.
     */
    val group: String?
    /**
     * The service of this graphql_type_entry.
     */
    val service: Service
    /**
     * The graphql_type of this graphql_type_entry.
     */
    val graphqlType: GraphqlType
    /**
     * Returns wether this instance is a graphql_type_entry or not.
     */
    val isaGraphqlTypeEntry: Boolean
}
