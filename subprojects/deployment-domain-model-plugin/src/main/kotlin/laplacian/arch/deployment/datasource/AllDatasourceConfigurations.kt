package laplacian.arch.deployment.datasource
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource

import laplacian.util.*

/**
 * All datasource_configurations.
 */
class AllDatasourceConfigurations(
    list: List<DatasourceConfiguration>,
    val context: Context
) : List<DatasourceConfiguration> by list {
}
