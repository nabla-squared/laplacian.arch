package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_response.
 */
data class RestOperationResponseRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationResponse, Record by _record {

    /**
     * The type of this rest_operation_response.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * Defines this rest_operation_response is optional or not.
     */
    override val optional: Boolean
        get() = getOrThrow("optional") {
            false
        }
    /**
     * Defines this rest_operation_response is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * The type_in_java of this rest_operation_response.
     */
    override val typeInJava: String
        get() = when(type) {
            "number" -> "Int"
            "object" -> "Map<String, Any?>"
            "array" -> "List<Any>"
            else -> type.upperCamelize()
        }.let {
            (if (multiple) "List<$it>" else it) + (if (optional) "?" else "")
        }
    /**
     * Returns wether this instance is a rest_operation_response or not.
     */
    override val isaRestOperationResponse: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationResponses {
            return _context.get("rest_operation_responses") as AllRestOperationResponses
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationResponseRecord(record, _context)
    }
}
