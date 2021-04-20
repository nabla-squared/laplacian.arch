package laplacian.arch.backend.api.graphql
import laplacian.metamodel.Entity
import laplacian.arch.backend.api.ConfigurationBinding
import laplacian.arch.backend.api.mybatis.MybatisFetcher


import laplacian.util.*

/**
 * An entity describing a graphql_type.
 */
interface GraphqlType {
    /**
     * The name of this graphql_type.
     */
    val name: String
    /**
     * The group of this graphql_type.
     */
    val group: String?
    /**
     * The description of this graphql_type.
     */
    val description: String
    /**
     * The data_model_name of this graphql_type.
     */
    val dataModelName: String?
    /**
     * The data_model_namespace of this graphql_type.
     */
    val dataModelNamespace: String?
    /**
     * Defines this graphql_type is depends_on_mybatis or not.
     */
    val dependsOnMybatis: Boolean
    /**
     * The fqn of this graphql_type.
     */
    val fqn: String
    /**
     * The graphql_type_name of this graphql_type.
     */
    val graphqlTypeName: String
    /**
     * The data_model of this graphql_type.
     */
    val dataModel: Entity?
    /**
     * The fields of this graphql_type.
     */
    val fields: List<GraphqlField>
    /**
     * The configurations of this graphql_type.
     */
    val configurations: List<ConfigurationBinding>
    /**
     * The query_fields of this graphql_type.
     */
    val queryFields: List<GraphqlField>
    /**
     * The root_query_fields of this graphql_type.
     */
    val rootQueryFields: List<GraphqlField>
    /**
     * The mutation_fields of this graphql_type.
     */
    val mutationFields: List<GraphqlField>
    /**
     * The root_mutation_fields of this graphql_type.
     */
    val rootMutationFields: List<GraphqlField>
    /**
     * The subscription_fields of this graphql_type.
     */
    val subscriptionFields: List<GraphqlField>
    /**
     * The root_subscription_fields of this graphql_type.
     */
    val rootSubscriptionFields: List<GraphqlField>
    /**
     * The referencing_graphql_types of this graphql_type.
     */
    val referencingGraphqlTypes: List<GraphqlType>
    /**
     * The mybatis_field_fetchers of this graphql_type.
     */
    val mybatisFieldFetchers: List<MybatisFetcher>
    /**
     * Returns wether this instance is a graphql_type or not.
     */
    val isaGraphqlType: Boolean
}
