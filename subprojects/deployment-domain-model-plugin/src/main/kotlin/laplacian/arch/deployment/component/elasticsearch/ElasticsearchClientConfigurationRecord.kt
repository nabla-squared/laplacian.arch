package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_client_configuration.
 */
data class ElasticsearchClientConfigurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticsearchClientConfiguration, Record by _record {

    /**
     * The name of this elasticsearch_client_configuration.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The port of this elasticsearch_client_configuration.
     */
    override val port: Int
        get() = getOrThrow("port") {
            9200
        }
    /**
     * The endpoints of this elasticsearch_client_configuration.
     */
    override val endpoints: List<String>
        get() = getOrThrow("endpoints") {
            listOf("http://${name}:${port}")
        }
    /**
     * Returns wether this instance is a elasticsearch_client_configuration or not.
     */
    override val isaElasticsearchClientConfiguration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticsearchClientConfigurations {
            return _context.get("elasticsearch_client_configurations") as AllElasticsearchClientConfigurations
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchClientConfigurationRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchClientConfigurationRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchClientConfigurationRecord(" +
            "name=$name" +
        ")"
    }
}
