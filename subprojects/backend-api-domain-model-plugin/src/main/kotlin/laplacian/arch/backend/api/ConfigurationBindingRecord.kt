package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.ServiceConfiguration




import laplacian.generate.util.*
/**
 * An entity describing a configuration_binding.
 */
data class ConfigurationBindingRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ConfigurationBinding, Record by _record {

    /**
     * The name of this configuration_binding.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The category of this configuration_binding.
     */
    override val category: String
        get() = getOrThrow("category")
    /**
     * The variable_name of this configuration_binding.
     */
    override val variableName: String
        get() = getOrThrow("variableName") {
            "${name.lowerCamelize()}"
        }
    /**
     * The definition of this configuration_binding.
     */
    override val definition: ServiceConfiguration by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.name == name &&
            it.category == category
        } ?: throw IllegalStateException(
            "There is no service_configuration which meets the following condition(s): "
            + "ConfigurationBinding.name == service_configuration.name (=$name) "
            + "ConfigurationBinding.category == service_configuration.category (=$category) "
            + "Possible values are: " + ServiceConfigurationRecord.from(_context).map {
              "(${ it.name },${ it.category })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a configuration_binding or not.
     */
    override val isaConfigurationBinding: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllConfigurationBindings {
            return _context.get("configuration_bindings") as AllConfigurationBindings
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ConfigurationBindingRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ConfigurationBindingRecord) return false
        if (name != other.name) return false
        if (category != other.category) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + category.hashCode()
        return result
    }

    override fun toString(): String {
        return "ConfigurationBindingRecord(" +
            "name=$name, " +
            "category=$category" +
        ")"
    }
}
