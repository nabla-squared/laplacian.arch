package laplacian.arch.backend.api.datasource
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All datasources.
 */
class AllDatasources(
    list: List<Datasource>,
    val context: Context
) : List<Datasource> by list {
}
