package laplacian.arch.backend.api


import laplacian.util.*

/**
 * An entity describing a api_call_argument.
 */
interface ApiCallArgument {
    /**
     * The name of this api_call_argument.
     */
    val name: String
    /**
     * The type of this api_call_argument.
     */
    val type: String
    /**
     * The description of this api_call_argument.
     */
    val description: String
    /**
     * Defines this api_call_argument is required or not.
     */
    val required: Boolean
    /**
     * Defines this api_call_argument is multiple or not.
     */
    val multiple: Boolean
    /**
     * Defines this api_call_argument is nullable or not.
     */
    val nullable: Boolean
    /**
     * The default_value of this api_call_argument.
     */
    val defaultValue: String
    /**
     * The class_name of this api_call_argument.
     */
    val className: String
    /**
     * The graphql_type of this api_call_argument.
     */
    val graphqlType: String
    /**
     * Returns wether this instance is a api_call_argument or not.
     */
    val isaApiCallArgument: Boolean
}
