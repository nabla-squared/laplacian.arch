package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlType


import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_type_reference.
 */
data class GraphqlTypeReferenceRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlType: GraphqlType,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldRecord(__record, _context, graphqlType), GraphqlTypeReference {

    /**
     * The graphql_type_name of this graphql_type_reference.
     */
    override val graphqlTypeName: String
        get() = getOrThrow("graphqlTypeName")
    /**
     * The graphql_type_group of this graphql_type_reference.
     */
    override val graphqlTypeGroup: String
        get() = getOrThrow("graphqlTypeGroup") {
            graphqlType.group
        }
    /**
     * The record_type of this graphql_type_reference.
     */
    override val recordType: String
        get() = referencingGraphqlType.name.upperCamelize()
    /**
     * The record_type_in_gql of this graphql_type_reference.
     */
    override val recordTypeInGql: String
        get() = referencingGraphqlType.graphqlTypeName
    /**
     * The referencing_graphql_type of this graphql_type_reference.
     */
    override val referencingGraphqlType: GraphqlType by lazy {
        GraphqlTypeRecord.from(_context).find {
            it.name == graphqlTypeName &&
            it.group == graphqlTypeGroup
        } ?: throw IllegalStateException(
            "There is no graphql_type which meets the following condition(s): "
            + "GraphqlTypeReference.graphql_type_name == graphql_type.name (=$graphqlTypeName) "
            + "GraphqlTypeReference.graphql_type_group == graphql_type.group (=$graphqlTypeGroup) "
            + "Possible values are: " + GraphqlTypeRecord.from(_context).map {
              "(${ it.name },${ it.group })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a graphql_type_reference or not.
     */
    override val isaGraphqlTypeReference: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlType: GraphqlType) = records
            .mergeWithKeys("name")
            .map { from(it, _context, graphqlType = graphqlType) }

        fun from(record: Record, _context: Context, graphqlType: GraphqlType) =
            GraphqlTypeReferenceRecord(record, _context, graphqlType = graphqlType)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GraphqlTypeReferenceRecord) return false
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
        return "GraphqlTypeReferenceRecord(" +
            "graphqlType=$graphqlType, " +
            "name=$name" +
        ")"
    }
}
