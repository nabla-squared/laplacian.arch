package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.container.ContainerDeployment

import laplacian.arch.deployment.component.container.EnvironmentVariableDefinition
import laplacian.arch.deployment.component.container.EnvironmentVariableDefinitionRecord



import laplacian.generate.util.*
/**
 * An entity describing a environment_variable_assignment.
 */
data class EnvironmentVariableAssignmentRecord (
    private val __record: Record,
    private val _context: Context,
    override val containerDeployment: ContainerDeployment,
    private val _record: Record = __record.normalizeCamelcase()
): EnvironmentVariableAssignment, Record by _record {

    /**
     * The name of this environment_variable_assignment.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The value of this environment_variable_assignment.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * The definition of this environment_variable_assignment.
     */
    override val definition: EnvironmentVariableDefinition by lazy {
        containerDeployment.containerImage.environmentVariables.find{ it.name == name }!!
    }
    /**
     * Returns wether this instance is a environment_variable_assignment or not.
     */
    override val isaEnvironmentVariableAssignment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, containerDeployment: ContainerDeployment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, containerDeployment = containerDeployment) }

        fun from(record: Record, _context: Context, containerDeployment: ContainerDeployment) =
            EnvironmentVariableAssignmentRecord(record, _context, containerDeployment = containerDeployment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EnvironmentVariableAssignmentRecord) return false
        if (containerDeployment != other.containerDeployment) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = containerDeployment.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "EnvironmentVariableAssignmentRecord(" +
            "containerDeployment=$containerDeployment, " +
            "name=$name" +
        ")"
    }
}
