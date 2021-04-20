package laplacian.arch.deployment.container
import laplacian.arch.deployment.component.container.EnvironmentVariableDefinition


import laplacian.util.*

/**
 * An entity describing a environment_variable_assignment.
 */
interface EnvironmentVariableAssignment {
    /**
     * The name of this environment_variable_assignment.
     */
    val name: String
    /**
     * The value of this environment_variable_assignment.
     */
    val value: String
    /**
     * The container_deployment of this environment_variable_assignment.
     */
    val containerDeployment: ContainerDeployment
    /**
     * The definition of this environment_variable_assignment.
     */
    val definition: EnvironmentVariableDefinition
    /**
     * Returns wether this instance is a environment_variable_assignment or not.
     */
    val isaEnvironmentVariableAssignment: Boolean
}
