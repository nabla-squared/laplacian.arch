package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context


import laplacian.arch.backend.api.rest.ArgumentAssignmentValueFetcherArgumentRecord
import laplacian.arch.backend.api.rest.ArgumentAssignmentValueGraphqlTypeConfigRecord
import laplacian.arch.backend.api.rest.ArgumentAssignmentValueExpressionRecord

import laplacian.generate.util.*
/**
 * An entity describing a argument_assignment_value.
 */
open class ArgumentAssignmentValueRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ArgumentAssignmentValue, Record by _record {

    /**
     * The from of this argument_assignment_value.
     */
    override val from: String
        get() = getOrThrow("from")
    /**
     * Returns wether this instance is a argument_assignment_value or not.
     */
    override val isaArgumentAssignmentValue: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllArgumentAssignmentValues {
            return _context.get("argument_assignment_values") as AllArgumentAssignmentValues
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["from"]) {
                "fetcher_argument" -> ArgumentAssignmentValueFetcherArgumentRecord(record, _context)
                "graphql_type_config" -> ArgumentAssignmentValueGraphqlTypeConfigRecord(record, _context)
                "expression" -> ArgumentAssignmentValueExpressionRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined from $type. It is should be one of [fetcher_argument, graphql_type_config, expression]. Record: $record"
                )
            }
    }
}
