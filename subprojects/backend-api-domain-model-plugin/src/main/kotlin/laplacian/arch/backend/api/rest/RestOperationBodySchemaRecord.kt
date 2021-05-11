package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord



import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_body_schema.
 */
data class RestOperationBodySchemaRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationBodySchema, Record by _record {

    /**
     * The name of this rest_operation_body_schema.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this rest_operation_body_schema.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * The model of this rest_operation_body_schema.
     */
    override val model: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == name &&
            it.namespace == namespace
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "RestOperationBodySchema.name == entity.name (=$name) "
            + "RestOperationBodySchema.namespace == entity.namespace (=$namespace) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a rest_operation_body_schema or not.
     */
    override val isaRestOperationBodySchema: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationBodySchemas {
            return _context.get("rest_operation_body_schemas") as AllRestOperationBodySchemas
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationBodySchemaRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RestOperationBodySchemaRecord) return false
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
        return "RestOperationBodySchemaRecord(" +
            "name=$name, " +
            "namespace=$namespace" +
        ")"
    }
}
