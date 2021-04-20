package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.RestResource

import laplacian.arch.backend.api.rest.RestOperation

import laplacian.arch.backend.api.rest.ArgumentAssignment

import laplacian.arch.backend.api.graphql.GraphqlField
import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord

import laplacian.generate.util.*
/**
 * An entity describing a rest_api_fetcher.
 */
data class RestApiFetcherRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcherRecord(__record, _context, graphqlField), RestApiFetcher {

    /**
     * The rest_resource_name of this rest_api_fetcher.
     */
    override val restResourceName: String
        get() = getOrThrow("restResourceName")
    /**
     * The rest_operation_name of this rest_api_fetcher.
     */
    override val restOperationName: String
        get() = getOrThrow("restOperationName")
    /**
     * The rest_resource of this rest_api_fetcher.
     */
    override val restResource: RestResource by lazy {
        RestResourceRecord.from(_context).find {
            it.name == restResourceName
        } ?: throw IllegalStateException(
            "There is no rest_resource which meets the following condition(s): "
            + "RestApiFetcher.rest_resource_name == rest_resource.name (=$restResourceName) "
            + "Possible values are: " + RestResourceRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The rest_operation of this rest_api_fetcher.
     */
    override val restOperation: RestOperation by lazy {
        restResource.operations.find{ it.name == restOperationName }!!
    }
    /**
     * The argument_assignments of this rest_api_fetcher.
     */
    override val argumentAssignments: List<ArgumentAssignment> by lazy {
        ArgumentAssignmentRecord.from(_record.getList("argument_assignments", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a rest_api_fetcher or not.
     */
    override val isaRestApiFetcher: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            RestApiFetcherRecord(record, _context, graphqlField = graphqlField)
    }
}
