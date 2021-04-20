package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a rest_request_parameter.
 */
data class RestRequestParameterRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestRequestParameter, Record by _record {

    /**
     * The name of this rest_request_parameter.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The type of this rest_request_parameter.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * Defines this rest_request_parameter is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * The value of this rest_request_parameter.
     */
    override val value: String
        get() = getOrThrow("value")
    /**
     * Defines this rest_request_parameter is variable or not.
     */
    override val variable: Boolean
        get() = value.contains("\${")
    /**
     * Returns wether this instance is a rest_request_parameter or not.
     */
    override val isaRestRequestParameter: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestRequestParameters {
            return _context.get("rest_request_parameters") as AllRestRequestParameters
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestRequestParameterRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestRequestParameterRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "RestRequestParameterRecord(" +
            "name=$name" +
        ")"
    }
}
