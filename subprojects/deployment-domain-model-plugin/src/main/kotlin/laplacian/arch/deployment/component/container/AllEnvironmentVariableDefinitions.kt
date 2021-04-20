package laplacian.arch.deployment.component.container
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All environment_variable_definitions.
 */
class AllEnvironmentVariableDefinitions(
    list: List<EnvironmentVariableDefinition>,
    val context: Context
) : List<EnvironmentVariableDefinition> by list {
}
