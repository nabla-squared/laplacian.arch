package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a service_configuration.
 */
data class ServiceConfigurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ServiceConfiguration, Record by _record {

    /**
     * The name of this service_configuration.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The category of this service_configuration.
     */
    override val category: String
        get() = getOrThrow("category")
    /**
     * The type of this service_configuration.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The key of this service_configuration.
     */
    override val key: String
        get() = "${category}.${name}"
    /**
     * The default_value of this service_configuration.
     */
    override val defaultValue: String?
        by _record
    /**
     * The environment_variable_name of this service_configuration.
     */
    override val environmentVariableName: String
        get() = getOrThrow("environmentVariableName") {
            "${key.upperUnderscorize()}"
        }
    /**
     * Returns wether this instance is a service_configuration or not.
     */
    override val isaServiceConfiguration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllServiceConfigurations {
            return _context.get("service_configurations") as AllServiceConfigurations
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ServiceConfigurationRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ServiceConfigurationRecord) return false
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
        return "ServiceConfigurationRecord(" +
            "name=$name, " +
            "category=$category" +
        ")"
    }
}
