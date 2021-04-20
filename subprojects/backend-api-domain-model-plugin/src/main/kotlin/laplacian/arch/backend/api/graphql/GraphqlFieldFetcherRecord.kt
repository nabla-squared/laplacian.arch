package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlField

import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.ApiCallArgumentRecord
import laplacian.arch.backend.api.graphql.GraphqlType

import laplacian.arch.backend.api.cache.CachePolicy
import laplacian.arch.backend.api.cache.CachePolicyRecord


import laplacian.arch.backend.api.data_file.DataFileFetcherRecord
import laplacian.arch.backend.api.graphql.CustomFetcherRecord
import laplacian.arch.backend.api.graphql.GraphqlFieldLinkRecord
import laplacian.arch.backend.api.mybatis.MybatisFetcherRecord
import laplacian.arch.backend.api.rest.RestApiFetcherRecord

import laplacian.generate.util.*
/**
 * An entity describing a graphql_field_fetcher.
 */
open class GraphqlFieldFetcherRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcher, Record by _record {

    /**
     * The type of this graphql_field_fetcher.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The description of this graphql_field_fetcher.
     */
    override val description: String
        get() = getOrThrow("description") {
            "The data fetcher for the ${graphqlField.name} field."
        }
    /**
     * Defines this graphql_field_fetcher is is_batch or not.
     */
    override val isBatch: Boolean
        get() = getOrThrow("isBatch") {
            false
        }
    /**
     * The result_selector of this graphql_field_fetcher.
     */
    override val resultSelector: String?
        by _record
    /**
     * The result_mapper of this graphql_field_fetcher.
     */
    override val resultMapper: String
        get() = getOrThrow("resultMapper") {
            "${graphqlField.recordType}.from(result)"
        }
    /**
     * The cache_policy_name of this graphql_field_fetcher.
     */
    override val cachePolicyName: String?
        by _record
    /**
     * The java_interface of this graphql_field_fetcher.
     */
    override val javaInterface: String
        get() = if (isBatch) "${javaInterfaceName}<${graphqlField.contextType}, ${graphqlField.recordType}>"
        else "${javaInterfaceName}<${graphqlField.recordType}>"
    /**
     * The java_interface_name of this graphql_field_fetcher.
     */
    override val javaInterfaceName: String
        get() = when {
          (isBatch && graphqlField.multiple) -> "ListValueFieldBatchFetcher"
          (isBatch && !graphqlField.multiple) -> "FieldBatchFetcher"
          (!isBatch && graphqlField.multiple) -> "ListValueFieldFetcher"
          (!isBatch && !graphqlField.multiple) -> "FieldFetcher"
          else -> ""
        }
    /**
     * The graphql_field_arguments of this graphql_field_fetcher.
     */
    override val graphqlFieldArguments: List<ApiCallArgument> by lazy {
        graphqlField.arguments
    }
    /**
     * The graphql_type of this graphql_field_fetcher.
     */
    override val graphqlType: GraphqlType by lazy {
        graphqlField.graphqlType
    }
    /**
     * The cache_policy of this graphql_field_fetcher.
     */
    override val cachePolicy: CachePolicy? by lazy {
        CachePolicyRecord.from(_context).find {
            it.name == cachePolicyName
        }
    }
    /**
     * Returns wether this instance is a graphql_field_fetcher or not.
     */
    override val isaGraphqlFieldFetcher: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            when (val type = record["type"]) {
                "data_file" -> DataFileFetcherRecord(record, _context, graphqlField = graphqlField)
                "custom" -> CustomFetcherRecord(record, _context, graphqlField = graphqlField)
                "graphql_field_link" -> GraphqlFieldLinkRecord(record, _context, graphqlField = graphqlField)
                "mybatis" -> MybatisFetcherRecord(record, _context, graphqlField = graphqlField)
                "rest_api" -> RestApiFetcherRecord(record, _context, graphqlField = graphqlField)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [data_file, custom, graphql_field_link, mybatis, rest_api]. Record: $record"
                )
            }
    }
}
