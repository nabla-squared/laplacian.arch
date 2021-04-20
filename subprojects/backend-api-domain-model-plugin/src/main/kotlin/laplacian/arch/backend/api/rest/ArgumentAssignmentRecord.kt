package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.ArgumentAssignmentValue




import laplacian.generate.util.*
/**
 * An entity describing a argument_assignment.
 */
data class ArgumentAssignmentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ArgumentAssignment, Record by _record {

    /**
     * The key of this argument_assignment.
     */
    override val key: String
        get() = getOrThrow("key")
    /**
     * The value of this argument_assignment.
     */
    override val value: ArgumentAssignmentValue by lazy {
        ArgumentAssignmentValueRecord(getOrThrow<Record>("value"), _context)
    }
    /**
     * Returns wether this instance is a argument_assignment or not.
     */
    override val isaArgumentAssignment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllArgumentAssignments {
            return _context.get("argument_assignments") as AllArgumentAssignments
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ArgumentAssignmentRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ArgumentAssignmentRecord) return false
        if (key != other.key) return false
        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        return result
    }

    override fun toString(): String {
        return "ArgumentAssignmentRecord(" +
            "key=$key" +
        ")"
    }
}
