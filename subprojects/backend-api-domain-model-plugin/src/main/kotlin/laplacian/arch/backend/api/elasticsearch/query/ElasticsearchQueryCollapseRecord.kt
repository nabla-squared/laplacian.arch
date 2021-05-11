package laplacian.arch.backend.api.elasticsearch.query
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_query_collapse.
 */
data class ElasticsearchQueryCollapseRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchQueryCollapse, Record by _record {

    /**
     * The field of this elasticsearch_query_collapse.
     */
    override val field: String
        get() = getOrThrow("field")
    /**
     * Returns wether this instance is a elasticsearch_query_collapse or not.
     */
    override val isaElasticsearchQueryCollapse: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchQueryCollapses {
            return _context.get("elasticsearch_query_collapses") as AllElasticsearchQueryCollapses
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchQueryCollapseRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchQueryCollapseRecord) return false
        if (field != other.field) return false
        return true
    }

    override fun hashCode(): Int {
        var result = field.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchQueryCollapseRecord(" +
            "field=$field" +
        ")"
    }
}
