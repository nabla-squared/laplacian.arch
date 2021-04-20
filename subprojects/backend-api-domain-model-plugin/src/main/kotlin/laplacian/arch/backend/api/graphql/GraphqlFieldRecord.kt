package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlType

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.ApiCallArgumentRecord


import laplacian.arch.backend.api.graphql.GraphqlCompositeFieldRecord
import laplacian.arch.backend.api.graphql.GraphqlScalarFieldRecord
import laplacian.arch.backend.api.graphql.GraphqlTypeReferenceRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_field.
 */
open class GraphqlFieldRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlType: GraphqlType,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlField, Record by _record {

    /**
     * The name of this graphql_field.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this graphql_field.
     */
    override val description: String
        get() = getOrThrow("description") {
            "The ${name} field."
        }
    /**
     * The field_type of this graphql_field.
     */
    override val fieldType: String
        get() = getOrThrow("fieldType")
    /**
     * Defines this graphql_field is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * Defines this graphql_field is optional or not.
     */
    override val optional: Boolean
        get() = getOrThrow("optional") {
            false
        }
    /**
     * The operation_type of this graphql_field.
     */
    override val operationType: String
        get() = getOrThrow("operationType") {
            "query"
        }
    /**
     * The context_data_model_name of this graphql_field.
     */
    override val contextDataModelName: String?
        by _record
    /**
     * The context_type of this graphql_field.
     */
    override val contextType: String?
        get() = when {
            rootField -> null
            (contextDataModelName == null) -> graphqlType.name
            else -> contextDataModelName
        }?.upperCamelize()
    /**
     * The record_type of this graphql_field.
     */
    override val recordType: String
        get() = "Any"
    /**
     * The record_type_in_gql of this graphql_field.
     */
    override val recordTypeInGql: String
        get() = recordType
    /**
     * The return_type of this graphql_field.
     */
    override val returnType: String
        get() = if (multiple) "List<${recordType}>" else recordType
    /**
     * The return_type_in_gql of this graphql_field.
     */
    override val returnTypeInGql: String
        get() = if (multiple) "[${recordTypeInGql}]" else recordTypeInGql
    /**
     * Specifies whether this field is shown in the root query object.
     */
    override val rootField: Boolean
        get() = getOrThrow("rootField") {
            false
        }
    /**
     * The fqn of this graphql_field.
     */
    override val fqn: String
        get() = "${graphqlType.fqn}.${name.lowerUnderscorize()}"
    /**
     * The fetcher of this graphql_field.
     */
    override val fetcher: GraphqlFieldFetcher? by lazy {
        getOrNull<Record>("fetcher")?.let{ GraphqlFieldFetcherRecord.from(it, _context, this) }
    }
    /**
     * The arguments of this graphql_field.
     */
    override val arguments: List<ApiCallArgument> by lazy {
        ApiCallArgumentRecord.from(_record.getList("arguments", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a graphql_field or not.
     */
    override val isaGraphqlField: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlType: GraphqlType) = records
            .mergeWithKeys("name")
            .map { from(it, _context, graphqlType = graphqlType) }

        fun from(record: Record, _context: Context, graphqlType: GraphqlType) =
            when (val type = record["field_type"]) {
                "composite" -> GraphqlCompositeFieldRecord(record, _context, graphqlType = graphqlType)
                "scalar" -> GraphqlScalarFieldRecord(record, _context, graphqlType = graphqlType)
                "graphql_type" -> GraphqlTypeReferenceRecord(record, _context, graphqlType = graphqlType)
                else -> throw IllegalArgumentException(
                    "The given record has undefined field_type $type. It is should be one of [composite, scalar, graphql_type]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GraphqlFieldRecord) return false
        if (graphqlType != other.graphqlType) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = graphqlType.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "GraphqlFieldRecord(" +
            "graphqlType=$graphqlType, " +
            "name=$name" +
        ")"
    }
}
