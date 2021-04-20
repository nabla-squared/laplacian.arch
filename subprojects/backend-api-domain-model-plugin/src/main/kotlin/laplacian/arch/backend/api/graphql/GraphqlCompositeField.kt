package laplacian.arch.backend.api.graphql
import laplacian.metamodel.Entity

import laplacian.arch.backend.api.graphql.GraphqlField

import laplacian.util.*

/**
 * An entity describing a graphql_composite_field.
 */
interface GraphqlCompositeField : GraphqlField {
    /**
     * The data_model_name of this graphql_composite_field.
     */
    val dataModelName: String
    /**
     * The data_model_namespace of this graphql_composite_field.
     */
    val dataModelNamespace: String
    /**
     * The data_model of this graphql_composite_field.
     */
    val dataModel: Entity
    /**
     * Returns wether this instance is a graphql_composite_field or not.
     */
    val isaGraphqlCompositeField: Boolean
}
