package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlType


import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_scalar_field.
 */
data class GraphqlScalarFieldRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlType: GraphqlType,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldRecord(__record, _context, graphqlType), GraphqlScalarField {

    /**
     * The value_type of this graphql_scalar_field.
     */
    override val valueType: String
        get() = getOrThrow("valueType")
    /**
     * The record_type of this graphql_scalar_field.
     */
    override val recordType: String
        get() = when (valueType) {
            "string" -> "String"
            "int" -> "Int"
            "float" -> "Float"
            else -> "Any"
        }
    /**
     * Returns wether this instance is a graphql_scalar_field or not.
     */
    override val isaGraphqlScalarField: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlType: GraphqlType) = records
            .mergeWithKeys("name")
            .map { from(it, _context, graphqlType = graphqlType) }

        fun from(record: Record, _context: Context, graphqlType: GraphqlType) =
            GraphqlScalarFieldRecord(record, _context, graphqlType = graphqlType)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GraphqlScalarFieldRecord) return false
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
        return "GraphqlScalarFieldRecord(" +
            "graphqlType=$graphqlType, " +
            "name=$name" +
        ")"
    }
}
