package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_response_mapping.
 */
data class RestOperationResponseMappingRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationResponseMapping, Record by _record {

    /**
     * The from of this rest_operation_response_mapping.
     */
    override val from: String?
        by _record
    /**
     * The to of this rest_operation_response_mapping.
     */
    override val to: String?
        by _record
    /**
     * Returns wether this instance is a rest_operation_response_mapping or not.
     */
    override val isaRestOperationResponseMapping: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationResponseMappings {
            return _context.get("rest_operation_response_mappings") as AllRestOperationResponseMappings
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationResponseMappingRecord(record, _context)
    }
}
