package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.RestResource

import laplacian.arch.backend.api.rest.RestOperation




import laplacian.generate.util.*
/**
 * An entity describing a rest_api_usage_example.
 */
data class RestApiUsageExampleRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestApiUsageExample, Record by _record {

    /**
     * The rest_resource_name of this rest_api_usage_example.
     */
    override val restResourceName: String
        get() = getOrThrow("restResourceName")
    /**
     * The namespace of this rest_api_usage_example.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The operation_name of this rest_api_usage_example.
     */
    override val operationName: String
        get() = getOrThrow("operationName")
    /**
     * The tags of this rest_api_usage_example.
     */
    override val tags: List<String>
        get() = getOrThrow("tags") {
            emptyList<String>()
        }
    /**
     * The usage of this rest_api_usage_example.
     */
    override val usage: String
        get() = getOrThrow("usage") {
            "${operation.method.lowerCamelize()} ${operation.path.spaceDelimited()} of a ${restResourceName.spaceDelimited()}".capitalizeFirst()
        }
    /**
     * The curl of this rest_api_usage_example.
     */
    override val curl: String
        get() = getOrThrow("curl")
    /**
     * The queryParameters of this rest_api_usage_example.
     */
    override val queryParameters: String
        get() = """\?(.*)'""".toRegex().find(curl)?.groupValues?.get(1) ?: ""
    /**
     * The request_body_json of this rest_api_usage_example.
     */
    override val requestBodyJson: String
        get() = """-d\s+'([\s\S]*)'""".toRegex().find(curl)?.groupValues?.get(1) ?: ""
    /**
     * The status_code of this rest_api_usage_example.
     */
    override val statusCode: Int
        get() = getOrThrow("statusCode")
    /**
     * The response_body_json of this rest_api_usage_example.
     */
    override val responseBodyJson: String
        get() = getOrThrow("responseBodyJson")
    /**
     * The rest_resource of this rest_api_usage_example.
     */
    override val restResource: RestResource by lazy {
        RestResourceRecord.from(_context).find {
            it.name == restResourceName &&
            it.namespace == namespace
        } ?: throw IllegalStateException(
            "There is no rest_resource which meets the following condition(s): "
            + "RestApiUsageExample.rest_resource_name == rest_resource.name (=$restResourceName) "
            + "RestApiUsageExample.namespace == rest_resource.namespace (=$namespace) "
            + "Possible values are: " + RestResourceRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * The operation of this rest_api_usage_example.
     */
    override val operation: RestOperation by lazy {
        restResource.operations.find{ it.name == operationName }!!
    }
    /**
     * Returns wether this instance is a rest_api_usage_example or not.
     */
    override val isaRestApiUsageExample: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestApiUsageExamples {
            return _context.get("rest_api_usage_examples") as AllRestApiUsageExamples
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestApiUsageExampleRecord(record, _context)
    }
}
