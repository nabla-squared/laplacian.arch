package laplacian.arch.backend.api.data_file

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.util.*

/**
 * A graphql field fetcher retrieving the value from a file located in the container.

 */
interface DataFileFetcher : GraphqlFieldFetcher {
    /**
     * The data_file of this data_file_fetcher.
     */
    val dataFile: DataFile
    /**
     * Returns wether this instance is a data_file_fetcher or not.
     */
    val isaDataFileFetcher: Boolean
}
