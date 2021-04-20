package laplacian.arch.deployment.component.container
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a environment_variable_definition.
 */
data class EnvironmentVariableDefinitionRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): EnvironmentVariableDefinition, Record by _record {

    /**
     * The name of this environment_variable_definition.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this environment_variable_definition.
     */
    override val description: String
        get() = getOrThrow("description") {
            name
        }
    /**
     * Defines this environment_variable_definition is optional or not.
     */
    override val optional: Boolean
        get() = getOrThrow("optional") {
            false
        }
    /**
     * The default_value of this environment_variable_definition.
     */
    override val defaultValue: String
        get() = getOrThrow("defaultValue")
    /**
     * Defines this environment_variable_definition is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * Returns wether this instance is a environment_variable_definition or not.
     */
    override val isaEnvironmentVariableDefinition: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllEnvironmentVariableDefinitions {
            return _context.get("environment_variable_definitions") as AllEnvironmentVariableDefinitions
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            EnvironmentVariableDefinitionRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EnvironmentVariableDefinitionRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "EnvironmentVariableDefinitionRecord(" +
            "name=$name" +
        ")"
    }
}
