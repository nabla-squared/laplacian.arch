package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All configuration_files.
 */
class AllConfigurationFiles(
    list: List<ConfigurationFile>,
    val context: Context
) : List<ConfigurationFile> by list {
}
