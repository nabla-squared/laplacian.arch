package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.RestOperationBodySchema




import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_body_definition.
 */
data class RestOperationBodyDefinitionRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationBodyDefinition, Record by _record {

    /**
     * The format of this rest_operation_body_definition.
     */
    override val format: String
        get() = getOrThrow("format")
    /**
     * Defines this rest_operation_body_definition is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            false
        }
    /**
     * Defines this rest_operation_body_definition is optional or not.
     */
    override val optional: Boolean
        get() = getOrThrow("optional") {
            false
        }
    /**
     * The schema of this rest_operation_body_definition.
     */
    override val schema: RestOperationBodySchema by lazy {
        RestOperationBodySchemaRecord(getOrThrow<Record>("schema"), _context)
    }
    /**
     * Returns wether this instance is a rest_operation_body_definition or not.
     */
    override val isaRestOperationBodyDefinition: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationBodyDefinitions {
            return _context.get("rest_operation_body_definitions") as AllRestOperationBodyDefinitions
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationBodyDefinitionRecord(record, _context)
    }
}
