package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord
import laplacian.arch.backend.api.graphql.GraphqlField

import laplacian.arch.backend.api.ConfigurationBinding
import laplacian.arch.backend.api.ConfigurationBindingRecord

import laplacian.arch.backend.api.mybatis.MybatisFetcher
import laplacian.arch.backend.api.mybatis.MybatisFetcherRecord



import laplacian.generate.util.*
/**
 * An entity describing a graphql_type.
 */
data class GraphqlTypeRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlType, Record by _record {

    /**
     * The name of this graphql_type.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The group of this graphql_type.
     */
    override val group: String?
        by _record
    /**
     * The description of this graphql_type.
     */
    override val description: String
        get() = getOrThrow("description") {
            "A Graphql type representing ${name}"
        }
    /**
     * The data_model_name of this graphql_type.
     */
    override val dataModelName: String?
        by _record
    /**
     * The data_model_namespace of this graphql_type.
     */
    override val dataModelNamespace: String?
        by _record
    /**
     * Defines this graphql_type is depends_on_mybatis or not.
     */
    override val dependsOnMybatis: Boolean
        get() = fields.any{ it.fetcher?.type == "mybatis" ?: false }
    /**
     * The fqn of this graphql_type.
     */
    override val fqn: String
        get() = "${if (group != null) "${group!!.lowerUnderscorize()}." else ""}${name.lowerUnderscorize()}"
    /**
     * The graphql_type_name of this graphql_type.
     */
    override val graphqlTypeName: String
        get() = fqn.upperCamelize()
    /**
     * The data_model of this graphql_type.
     */
    override val dataModel: Entity? by lazy {
        EntityRecord.from(_context).find {
            it.name == dataModelName &&
            it.namespace == dataModelNamespace
        }
    }
    /**
     * The fields of this graphql_type.
     */
    override val fields: List<GraphqlField> by lazy {
        GraphqlFieldRecord.from(_record.getList("fields", emptyList()), _context, this)
    }
    /**
     * The configurations of this graphql_type.
     */
    override val configurations: List<ConfigurationBinding> by lazy {
        ConfigurationBindingRecord.from(_record.getList("configurations", emptyList()), _context)
    }
    /**
     * The query_fields of this graphql_type.
     */
    override val queryFields: List<GraphqlField> by lazy {
        fields.filter{ it.operationType == "query" }
    }
    /**
     * The root_query_fields of this graphql_type.
     */
    override val rootQueryFields: List<GraphqlField> by lazy {
        queryFields.filter{ it.rootField }
    }
    /**
     * The mutation_fields of this graphql_type.
     */
    override val mutationFields: List<GraphqlField> by lazy {
        fields.filter{ it.operationType == "mutation" }
    }
    /**
     * The root_mutation_fields of this graphql_type.
     */
    override val rootMutationFields: List<GraphqlField> by lazy {
        mutationFields.filter{ it.rootField }
    }
    /**
     * The subscription_fields of this graphql_type.
     */
    override val subscriptionFields: List<GraphqlField> by lazy {
        fields.filter{ it.operationType == "subscription" }
    }
    /**
     * The root_subscription_fields of this graphql_type.
     */
    override val rootSubscriptionFields: List<GraphqlField> by lazy {
        subscriptionFields.filter{ it.rootField }
    }
    /**
     * The referencing_graphql_types of this graphql_type.
     */
    override val referencingGraphqlTypes: List<GraphqlType> by lazy {
        fields
        .filterIsInstance<GraphqlTypeReference>()
        .map{ it.referencingGraphqlType }
        .filter{ it != this }
        .distinct()
    }
    /**
     * The mybatis_field_fetchers of this graphql_type.
     */
    override val mybatisFieldFetchers: List<MybatisFetcher> by lazy {
        fields
        .mapNotNull{ it.fetcher }
        .filterIsInstance<MybatisFetcher>()
    }
    /**
     * Returns wether this instance is a graphql_type or not.
     */
    override val isaGraphqlType: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllGraphqlTypes {
            return _context.get("graphql_types") as AllGraphqlTypes
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            GraphqlTypeRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GraphqlTypeRecord) return false
        if (name != other.name) return false
        if (group != other.group) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + group.hashCode()
        return result
    }

    override fun toString(): String {
        return "GraphqlTypeRecord(" +
            "name=$name, " +
            "group=$group" +
        ")"
    }
}
