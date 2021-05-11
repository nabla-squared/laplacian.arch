package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource

import laplacian.util.*

/**
 * All datasource_entries.
 */
class AllDatasourceEntries(
    list: List<DatasourceEntry>,
    val context: Context
) : List<DatasourceEntry> by list {
}
