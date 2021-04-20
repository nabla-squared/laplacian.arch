package laplacian.arch.deployment.component.container


import laplacian.util.*

/**
 * An entity describing a environment_variable_definition.
 */
interface EnvironmentVariableDefinition {
    /**
     * The name of this environment_variable_definition.
     */
    val name: String
    /**
     * The description of this environment_variable_definition.
     */
    val description: String
    /**
     * Defines this environment_variable_definition is optional or not.
     */
    val optional: Boolean
    /**
     * The default_value of this environment_variable_definition.
     */
    val defaultValue: String
    /**
     * Defines this environment_variable_definition is multiple or not.
     */
    val multiple: Boolean
    /**
     * Returns wether this instance is a environment_variable_definition or not.
     */
    val isaEnvironmentVariableDefinition: Boolean
}
