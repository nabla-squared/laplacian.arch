package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.Service

import laplacian.arch.backend.api.graphql.GraphqlType
import laplacian.arch.backend.api.graphql.GraphqlTypeRecord



import laplacian.generate.util.*
/**
 * An entity describing a graphql_type_entry.
 */
data class GraphqlTypeEntryRecord (
    private val __record: Record,
    private val _context: Context,
    override val service: Service,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlTypeEntry, Record by _record {

    /**
     * The name of this graphql_type_entry.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The group of this graphql_type_entry.
     */
    override val group: String?
        by _record
    /**
     * The graphql_type of this graphql_type_entry.
     */
    override val graphqlType: GraphqlType by lazy {
        GraphqlTypeRecord.from(_context).find {
            it.name == name &&
            it.group == group
        } ?: throw IllegalStateException(
            "There is no graphql_type which meets the following condition(s): "
            + "GraphqlTypeEntry.name == graphql_type.name (=$name) "
            + "GraphqlTypeEntry.group == graphql_type.group (=$group) "
            + "Possible values are: " + GraphqlTypeRecord.from(_context).map {
              "(${ it.name },${ it.group })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a graphql_type_entry or not.
     */
    override val isaGraphqlTypeEntry: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, service: Service) = records
            .map { from(it, _context, service = service) }

        fun from(record: Record, _context: Context, service: Service) =
            GraphqlTypeEntryRecord(record, _context, service = service)
    }
}
