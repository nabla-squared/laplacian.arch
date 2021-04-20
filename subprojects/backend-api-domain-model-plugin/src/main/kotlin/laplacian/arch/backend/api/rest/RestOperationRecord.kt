package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.ApiCallArgumentRecord
import laplacian.arch.backend.api.rest.RestRequestParameter

import laplacian.arch.backend.api.rest.RestResource

import laplacian.arch.backend.api.rest.RestOperationResponse




import laplacian.generate.util.*
/**
 * An entity describing a rest_operation.
 */
data class RestOperationRecord (
    private val __record: Record,
    private val _context: Context,
    override val restResource: RestResource,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperation, Record by _record {

    /**
     * The method of this rest_operation.
     */
    override val method: String
        get() = getOrThrow("method")
    /**
     * The path of this rest_operation.
     */
    override val path: String
        get() = getOrThrow("path")
    /**
     * The name of this rest_operation.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The description of this rest_operation.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${method} ${path}"
        }
    /**
     * The arguments of this rest_operation.
     */
    override val arguments: List<ApiCallArgument> by lazy {
        ApiCallArgumentRecord.from(_record.getList("arguments", emptyList()), _context)
    }
    /**
     * The path_parameters of this rest_operation.
     */
    override val pathParameters: List<RestRequestParameter> by lazy {
        RestRequestParameterRecord.from(_record.getList("path_parameters", emptyList()), _context)
    }
    /**
     * The query_parameters of this rest_operation.
     */
    override val queryParameters: List<RestRequestParameter> by lazy {
        RestRequestParameterRecord.from(_record.getList("query_parameters", emptyList()), _context)
    }
    /**
     * The http_headers of this rest_operation.
     */
    override val httpHeaders: List<RestRequestParameter> by lazy {
        RestRequestParameterRecord.from(_record.getList("http_headers", emptyList()), _context)
    }
    /**
     * The response of this rest_operation.
     */
    override val response: RestOperationResponse by lazy {
        RestOperationResponseRecord(getOrThrow<Record>("response"), _context)
    }
    /**
     * Returns wether this instance is a rest_operation or not.
     */
    override val isaRestOperation: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, restResource: RestResource) = records
            .mergeWithKeys("name")
            .map { from(it, _context, restResource = restResource) }

        fun from(record: Record, _context: Context, restResource: RestResource) =
            RestOperationRecord(record, _context, restResource = restResource)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestOperationRecord) return false
        if (restResource != other.restResource) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = restResource.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "RestOperationRecord(" +
            "restResource=$restResource, " +
            "name=$name" +
        ")"
    }
}
