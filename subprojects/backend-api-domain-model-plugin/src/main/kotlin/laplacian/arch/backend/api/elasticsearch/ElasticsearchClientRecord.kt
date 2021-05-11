package laplacian.arch.backend.api.elasticsearch
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_client.
 */
data class ElasticsearchClientRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchClient, Record by _record {

    /**
     * The name of this elasticsearch_client.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * Defines this elasticsearch_client is primary or not.
     */
    override val primary: Boolean
        get() = getOrThrow("primary") {
            false
        }
    /**
     * Returns wether this instance is a elasticsearch_client or not.
     */
    override val isaElasticsearchClient: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchClients {
            return _context.get("elasticsearch_clients") as AllElasticsearchClients
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchClientRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchClientRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchClientRecord(" +
            "name=$name" +
        ")"
    }
}
