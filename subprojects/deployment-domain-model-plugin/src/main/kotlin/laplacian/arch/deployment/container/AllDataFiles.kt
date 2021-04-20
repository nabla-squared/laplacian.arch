package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Dataset

import laplacian.util.*

/**
 * All data_files.
 */
class AllDataFiles(
    list: List<DataFile>,
    val context: Context
) : List<DataFile> by list {
}
