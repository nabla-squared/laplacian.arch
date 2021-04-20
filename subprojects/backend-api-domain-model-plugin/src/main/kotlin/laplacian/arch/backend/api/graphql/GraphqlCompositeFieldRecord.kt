package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord
import laplacian.arch.backend.api.graphql.GraphqlType


import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_composite_field.
 */
data class GraphqlCompositeFieldRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlType: GraphqlType,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldRecord(__record, _context, graphqlType), GraphqlCompositeField {

    /**
     * The data_model_name of this graphql_composite_field.
     */
    override val dataModelName: String
        get() = getOrThrow("dataModelName")
    /**
     * The data_model_namespace of this graphql_composite_field.
     */
    override val dataModelNamespace: String
        get() = getOrThrow("dataModelNamespace")
    /**
     * The record_type of this graphql_composite_field.
     */
    override val recordType: String
        get() = dataModelName.upperCamelize()
    /**
     * The data_model of this graphql_composite_field.
     */
    override val dataModel: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == dataModelName &&
            it.namespace == dataModelNamespace
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "GraphqlCompositeField.data_model_name == entity.name (=$dataModelName) "
            + "GraphqlCompositeField.data_model_namespace == entity.namespace (=$dataModelNamespace) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a graphql_composite_field or not.
     */
    override val isaGraphqlCompositeField: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlType: GraphqlType) = records
            .mergeWithKeys("name")
            .map { from(it, _context, graphqlType = graphqlType) }

        fun from(record: Record, _context: Context, graphqlType: GraphqlType) =
            GraphqlCompositeFieldRecord(record, _context, graphqlType = graphqlType)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GraphqlCompositeFieldRecord) return false
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
        return "GraphqlCompositeFieldRecord(" +
            "graphqlType=$graphqlType, " +
            "name=$name" +
        ")"
    }
}
