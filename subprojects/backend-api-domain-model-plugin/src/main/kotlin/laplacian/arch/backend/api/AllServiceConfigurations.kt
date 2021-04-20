package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All service_configurations.
 */
class AllServiceConfigurations(
    list: List<ServiceConfiguration>,
    val context: Context
) : List<ServiceConfiguration> by list {
}
