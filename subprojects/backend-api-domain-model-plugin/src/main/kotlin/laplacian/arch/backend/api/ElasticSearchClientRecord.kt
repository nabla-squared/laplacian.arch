package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.ServiceConfiguration




import laplacian.generate.util.*
/**
 * An entity describing a elastic_search_client.
 */
data class ElasticSearchClientRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ElasticSearchClient, Record by _record {

    /**
     * The name of this elastic_search_client.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * Defines this elastic_search_client is is_default or not.
     */
    override val isDefault: Boolean
        get() = getOrThrow("isDefault") {
            false
        }
    /**
     * The configuration_category of this elastic_search_client.
     */
    override val configurationCategory: String
        get() = getOrThrow("configurationCategory") {
            name.lowerHyphenize()
        }
    /**
     * The configuration_name_of_endpoints of this elastic_search_client.
     */
    override val configurationNameOfEndpoints: String
        get() = getOrThrow("configurationNameOfEndpoints") {
            "endpoints"
        }
    /**
     * The configuration_name_of_path_prefix of this elastic_search_client.
     */
    override val configurationNameOfPathPrefix: String
        get() = getOrThrow("configurationNameOfPathPrefix") {
            "path-prefix"
        }
    /**
     * The configuration_name_of_connect_timeout of this elastic_search_client.
     */
    override val configurationNameOfConnectTimeout: String
        get() = getOrThrow("configurationNameOfConnectTimeout") {
            "connect-timeout"
        }
    /**
     * The configuration_name_of_socket_timeout of this elastic_search_client.
     */
    override val configurationNameOfSocketTimeout: String
        get() = getOrThrow("configurationNameOfSocketTimeout") {
            "socket-timeout"
        }
    /**
     * The configuration_name_of_max_in_memory_size of this elastic_search_client.
     */
    override val configurationNameOfMaxInMemorySize: String
        get() = getOrThrow("configurationNameOfMaxInMemorySize") {
            "max-in-memory-size"
        }
    /**
     * The configurations of this elastic_search_client.
     */
    override val configurations: List<ServiceConfiguration> by lazy {
        listOf(
            endpoints,
            pathPrefix,
            connectTimeout,
            socketTimeout,
            maxInMemorySize
        )
        .filterNotNull()
    }
    /**
     * The endpoints of this elastic_search_client.
     */
    override val endpoints: ServiceConfiguration by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.category == configurationCategory &&
            it.name == configurationNameOfEndpoints
        } ?: throw IllegalStateException(
            "There is no service_configuration which meets the following condition(s): "
            + "ElasticSearchClient.configuration_category == service_configuration.category (=$configurationCategory) "
            + "ElasticSearchClient.configuration_name_of_endpoints == service_configuration.name (=$configurationNameOfEndpoints) "
            + "Possible values are: " + ServiceConfigurationRecord.from(_context).map {
              "(${ it.category },${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The path_prefix of this elastic_search_client.
     */
    override val pathPrefix: ServiceConfiguration? by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.category == configurationCategory &&
            it.name == configurationNameOfPathPrefix
        }
    }
    /**
     * The connect_timeout of this elastic_search_client.
     */
    override val connectTimeout: ServiceConfiguration? by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.category == configurationCategory &&
            it.name == configurationNameOfConnectTimeout
        }
    }
    /**
     * The socket_timeout of this elastic_search_client.
     */
    override val socketTimeout: ServiceConfiguration? by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.category == configurationCategory &&
            it.name == configurationNameOfSocketTimeout
        }
    }
    /**
     * The max_in_memory_size of this elastic_search_client.
     */
    override val maxInMemorySize: ServiceConfiguration? by lazy {
        ServiceConfigurationRecord.from(_context).find {
            it.category == configurationCategory &&
            it.name == configurationNameOfMaxInMemorySize
        }
    }
    /**
     * Returns wether this instance is a elastic_search_client or not.
     */
    override val isaElasticSearchClient: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllElasticSearchClients {
            return _context.get("elastic_search_clients") as AllElasticSearchClients
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticSearchClientRecord(record, _context)
    }
}
