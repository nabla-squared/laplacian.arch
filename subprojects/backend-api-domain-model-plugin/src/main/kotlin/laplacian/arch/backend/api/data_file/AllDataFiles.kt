package laplacian.arch.backend.api.data_file
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All data_files.
 */
class AllDataFiles(
    list: List<DataFile>,
    val context: Context
) : List<DataFile> by list {
}
