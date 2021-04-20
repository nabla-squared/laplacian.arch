package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a api_call_argument.
 */
data class ApiCallArgumentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ApiCallArgument, Record by _record {

    /**
     * The name of this api_call_argument.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The type of this api_call_argument.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The description of this api_call_argument.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${name}"
        }
    /**
     * Defines this api_call_argument is required or not.
     */
    override val required: Boolean
        get() = getOrThrow("required") {
            false
        }
    /**
     * Defines this api_call_argument is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * Defines this api_call_argument is nullable or not.
     */
    override val nullable: Boolean
        get() = !multiple && !required && !containsKey("default_value")
    /**
     * The default_value of this api_call_argument.
     */
    override val defaultValue: String
        get() = getOrThrow("defaultValue") {
            if (nullable) "null"
            else if (multiple) "emptyList()"
            else when(type) {
                "boolean" -> "false"
                "int" -> "0"
                "double" -> "0"
                "float" -> "0f"
                else -> "\"\""
            }
        }
    /**
     * The class_name of this api_call_argument.
     */
    override val className: String
        get() = when(type) {
            "boolean" -> "Boolean"
            "int" -> "Int"
            "float" -> "Float"
            else -> "String"
        }.let { if (multiple) "List<${it}>" else it }
    /**
     * The graphql_type of this api_call_argument.
     */
    override val graphqlType: String
        get() = when(type) {
            "datetime" -> "DateTime"
            else -> type.upperCamelize()
        }.let { if (multiple) "[${it}!]" else it }
    /**
     * Returns wether this instance is a api_call_argument or not.
     */
    override val isaApiCallArgument: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllApiCallArguments {
            return _context.get("api_call_arguments") as AllApiCallArguments
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ApiCallArgumentRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ApiCallArgumentRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ApiCallArgumentRecord(" +
            "name=$name" +
        ")"
    }
}
