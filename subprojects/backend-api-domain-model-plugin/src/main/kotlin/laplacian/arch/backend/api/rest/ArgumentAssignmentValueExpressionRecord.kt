package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.rest.ArgumentAssignmentValueRecord

import laplacian.generate.util.*
/**
 * An entity describing a argument_assignment_value_expression.
 */
data class ArgumentAssignmentValueExpressionRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ArgumentAssignmentValueRecord(__record, _context), ArgumentAssignmentValueExpression {

    /**
     * The expression of this argument_assignment_value_expression.
     */
    override val expression: String
        get() = getOrThrow("expression")
    /**
     * Returns wether this instance is a argument_assignment_value_expression or not.
     */
    override val isaArgumentAssignmentValueExpression: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ArgumentAssignmentValueExpressionRecord(record, _context)
    }
}
