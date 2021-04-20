package laplacian.arch.backend.api.graphql
import laplacian.arch.backend.api.ApiCallArgument


import laplacian.util.*

/**
 * An entity describing a graphql_field.
 */
interface GraphqlField {
    /**
     * The name of this graphql_field.
     */
    val name: String
    /**
     * The description of this graphql_field.
     */
    val description: String
    /**
     * The field_type of this graphql_field.
     */
    val fieldType: String
    /**
     * Defines this graphql_field is multiple or not.
     */
    val multiple: Boolean
    /**
     * Defines this graphql_field is optional or not.
     */
    val optional: Boolean
    /**
     * The operation_type of this graphql_field.
     */
    val operationType: String
    /**
     * The context_data_model_name of this graphql_field.
     */
    val contextDataModelName: String?
    /**
     * The context_type of this graphql_field.
     */
    val contextType: String?
    /**
     * The record_type of this graphql_field.
     */
    val recordType: String
    /**
     * The record_type_in_gql of this graphql_field.
     */
    val recordTypeInGql: String
    /**
     * The return_type of this graphql_field.
     */
    val returnType: String
    /**
     * The return_type_in_gql of this graphql_field.
     */
    val returnTypeInGql: String
    /**
     * Specifies whether this field is shown in the root query object.

     */
    val rootField: Boolean
    /**
     * The fqn of this graphql_field.
     */
    val fqn: String
    /**
     * The graphql_type of this graphql_field.
     */
    val graphqlType: GraphqlType
    /**
     * The fetcher of this graphql_field.
     */
    val fetcher: GraphqlFieldFetcher?
    /**
     * The arguments of this graphql_field.
     */
    val arguments: List<ApiCallArgument>
    /**
     * Returns wether this instance is a graphql_field or not.
     */
    val isaGraphqlField: Boolean
}
