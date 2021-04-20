package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlType

import laplacian.arch.backend.api.graphql.GraphqlField


import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_field_link.
 */
data class GraphqlFieldLinkRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcherRecord(__record, _context, graphqlField), GraphqlFieldLink {

    /**
     * The type_name of this graphql_field_link.
     */
    override val typeName: String
        get() = getOrThrow("typeName")
    /**
     * The group of this graphql_field_link.
     */
    override val group: String
        get() = getOrThrow("group") {
            graphqlType.group
        }
    /**
     * The field_name of this graphql_field_link.
     */
    override val fieldName: String
        get() = getOrThrow("fieldName")
    /**
     * The linked_graphql_type of this graphql_field_link.
     */
    override val linkedGraphqlType: GraphqlType by lazy {
        GraphqlTypeRecord.from(_context).find {
            it.name == typeName &&
            it.group == group
        } ?: throw IllegalStateException(
            "There is no graphql_type which meets the following condition(s): "
            + "GraphqlFieldLink.type_name == graphql_type.name (=$typeName) "
            + "GraphqlFieldLink.group == graphql_type.group (=$group) "
            + "Possible values are: " + GraphqlTypeRecord.from(_context).map {
              "(${ it.name },${ it.group })"
            }.joinToString()
        )
    }
    /**
     * The linked_graphql_field of this graphql_field_link.
     */
    override val linkedGraphqlField: GraphqlField by lazy {
        linkedGraphqlType.fields.find{ it.name == fieldName }!!
    }
    /**
     * Returns wether this instance is a graphql_field_link or not.
     */
    override val isaGraphqlFieldLink: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            GraphqlFieldLinkRecord(record, _context, graphqlField = graphqlField)
    }
}
