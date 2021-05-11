package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.Aggregate


import laplacian.arch.backend.api.aggregate.AggregateAccessMethodRecord

import laplacian.generate.util.*
/**
 * An entity describing a mybatis_access_method.
 */
data class MybatisAccessMethodRecord (
    private val __record: Record,
    private val _context: Context,
    override val aggregate: Aggregate,
    private val _record: Record = __record.normalizeCamelcase()
): AggregateAccessMethodRecord(__record, _context, aggregate), MybatisAccessMethod {

    /**
     * The datasource_name of this mybatis_access_method.
     */
    override val datasourceName: String?
        by _record
    /**
     * The statement_type of this mybatis_access_method.
     */
    override val statementType: String
        get() = getOrThrow("statementType")
    /**
     * The statement of this mybatis_access_method.
     */
    override val statement: String
        get() = getOrThrow("statement")
    /**
     * Returns wether this instance is a mybatis_access_method or not.
     */
    override val isaMybatisAccessMethod: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, aggregate: Aggregate) = records
            .mergeWithKeys("name")
            .map { from(it, _context, aggregate = aggregate) }

        fun from(record: Record, _context: Context, aggregate: Aggregate) =
            MybatisAccessMethodRecord(record, _context, aggregate = aggregate)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MybatisAccessMethodRecord) return false
        if (aggregate != other.aggregate) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = aggregate.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "MybatisAccessMethodRecord(" +
            "aggregate=$aggregate, " +
            "name=$name" +
        ")"
    }
}
