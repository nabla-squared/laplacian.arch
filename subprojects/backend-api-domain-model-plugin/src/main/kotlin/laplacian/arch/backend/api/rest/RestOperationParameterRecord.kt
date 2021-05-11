package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_parameter.
 */
data class RestOperationParameterRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationParameter, Record by _record {

    /**
     * The name of this rest_operation_parameter.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this rest_operation_parameter.
     */
    override val description: String
        get() = getOrThrow("description") {
            "$name"
        }
    /**
     * Defines this rest_operation_parameter is required or not.
     */
    override val required: Boolean
        get() = getOrThrow("required") {
            false
        }
    /**
     * The type of this rest_operation_parameter.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * Defines this rest_operation_parameter is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * The type_in_java of this rest_operation_parameter.
     */
    override val typeInJava: String
        get() = when (type) {
          "string" -> "String"
          "number" -> "Integer"
          "float" -> "Double"
          "boolean" -> "boolean"
          "object" -> "Map<String, Object>"
          else -> throw IllegalArgumentException("Can not handle type: $type")
        }
    /**
     * Returns wether this instance is a rest_operation_parameter or not.
     */
    override val isaRestOperationParameter: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationParameters {
            return _context.get("rest_operation_parameters") as AllRestOperationParameters
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationParameterRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestOperationParameterRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "RestOperationParameterRecord(" +
            "name=$name" +
        ")"
    }
}
