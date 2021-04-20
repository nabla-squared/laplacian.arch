package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context

import laplacian.arch.backend.api.rest.ArgumentAssignmentValueRecord

import laplacian.generate.util.*
/**
 * An entity describing a argument_assignment_value_fetcher_argument.
 */
data class ArgumentAssignmentValueFetcherArgumentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ArgumentAssignmentValueRecord(__record, _context), ArgumentAssignmentValueFetcherArgument {

    /**
     * The name of this argument_assignment_value_fetcher_argument.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * Returns wether this instance is a argument_assignment_value_fetcher_argument or not.
     */
    override val isaArgumentAssignmentValueFetcherArgument: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ArgumentAssignmentValueFetcherArgumentRecord(record, _context)
    }
}
