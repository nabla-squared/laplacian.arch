package laplacian.arch.backend.api.data_file
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.data_file.DataFile

import laplacian.arch.backend.api.graphql.GraphqlField
import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord

import laplacian.generate.util.*
/**
 * A graphql field fetcher retrieving the value from a file located in the container.
 */
data class DataFileFetcherRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcherRecord(__record, _context, graphqlField), DataFileFetcher {

    /**
     * The data_file of this data_file_fetcher.
     */
    override val dataFile: DataFile by lazy {
        DataFileRecord(getOrThrow<Record>("data_file"), _context)
    }
    /**
     * Returns wether this instance is a data_file_fetcher or not.
     */
    override val isaDataFileFetcher: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            DataFileFetcherRecord(record, _context, graphqlField = graphqlField)
    }
}
