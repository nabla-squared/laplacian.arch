package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicate
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord



import laplacian.generate.util.*
/**
 * An entity describing a keyed_filter.
 */
data class KeyedFilterRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): KeyedFilter, Record by _record {

    /**
     * The key of this keyed_filter.
     */
    override val key: String
        get() = getOrThrow("key")
    /**
     * The predicate of this keyed_filter.
     */
    override val predicate: ElasticsearchQueryPredicate by lazy {
        ElasticsearchQueryPredicateRecord(getOrThrow<Record>("predicate"), _context)
    }
    /**
     * Returns wether this instance is a keyed_filter or not.
     */
    override val isaKeyedFilter: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllKeyedFilters {
            return _context.get("keyed_filters") as AllKeyedFilters
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            KeyedFilterRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KeyedFilterRecord) return false
        if (key != other.key) return false
        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        return result
    }

    override fun toString(): String {
        return "KeyedFilterRecord(" +
            "key=$key" +
        ")"
    }
}
