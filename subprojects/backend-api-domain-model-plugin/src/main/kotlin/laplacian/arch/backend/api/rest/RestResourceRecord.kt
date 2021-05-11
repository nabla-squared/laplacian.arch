package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.rest.RestOperation

import laplacian.arch.backend.api.ConfigurationBinding
import laplacian.arch.backend.api.ConfigurationBindingRecord



import laplacian.generate.util.*
/**
 * An entity describing a rest_resource.
 */
data class RestResourceRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestResource, Record by _record {

    /**
     * The name of this rest_resource.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this rest_resource.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The path of this rest_resource.
     */
    override val path: String
        get() = getOrThrow("path")
    /**
     * The description of this rest_resource.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${name}"
        }
    /**
     * The resource_model_name of this rest_resource.
     */
    override val resourceModelName: String?
        by _record
    /**
     * The operations of this rest_resource.
     */
    override val operations: List<RestOperation> by lazy {
        RestOperationRecord.from(_record.getList("operations"), _context, this)
    }
    /**
     * The configurations of this rest_resource.
     */
    override val configurations: List<ConfigurationBinding> by lazy {
        ConfigurationBindingRecord.from(_record.getList("configurations", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a rest_resource or not.
     */
    override val isaRestResource: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestResources {
            return _context.get("rest_resources") as AllRestResources
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestResourceRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestResourceRecord) return false
        if (name != other.name) return false
        if (namespace != other.namespace) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + namespace.hashCode()
        return result
    }

    override fun toString(): String {
        return "RestResourceRecord(" +
            "name=$name, " +
            "namespace=$namespace" +
        ")"
    }
}
