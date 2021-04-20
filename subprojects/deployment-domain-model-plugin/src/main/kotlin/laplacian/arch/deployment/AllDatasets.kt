package laplacian.arch.deployment
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All datasets.
 */
class AllDatasets(
    list: List<Dataset>,
    val context: Context
) : List<Dataset> by list {
}
