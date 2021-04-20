package laplacian.arch.backend.api.datasource
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All datasource_entries.
 */
class AllDatasourceEntries(
    list: List<DatasourceEntry>,
    val context: Context
) : List<DatasourceEntry> by list {
}
