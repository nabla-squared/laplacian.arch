package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All configuration_bindings.
 */
class AllConfigurationBindings(
    list: List<ConfigurationBinding>,
    val context: Context
) : List<ConfigurationBinding> by list {
}
