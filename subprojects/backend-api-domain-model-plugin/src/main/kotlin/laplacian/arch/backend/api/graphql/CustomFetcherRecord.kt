package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.graphql.GraphqlField


import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord

import laplacian.generate.util.*
/**
 * An entity describing a custom_fetcher.
 */
data class CustomFetcherRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcherRecord(__record, _context, graphqlField), CustomFetcher {

    /**
     * Defines this custom_fetcher is async or not.
     */
    override val async: Boolean
        get() = getOrThrow("async") {
            true
        }
    /**
     * Returns wether this instance is a custom_fetcher or not.
     */
    override val isaCustomFetcher: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            CustomFetcherRecord(record, _context, graphqlField = graphqlField)
    }
}
