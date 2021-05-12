package laplacian.arch.backend.api.rest
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.Aggregate
import laplacian.arch.backend.api.aggregate.AggregateRecord
import laplacian.arch.backend.api.aggregate.AggregateAccessMethod
import laplacian.arch.backend.api.aggregate.AggregateAccessMethodRecord
import laplacian.arch.backend.api.rest.RestOperationResponseMapping




import laplacian.generate.util.*
/**
 * An entity describing a rest_operation_dependency.
 */
data class RestOperationDependencyRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): RestOperationDependency, Record by _record {

    /**
     * The type of this rest_operation_dependency.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The aggregate_name of this rest_operation_dependency.
     */
    override val aggregateName: String
        get() = getOrThrow("aggregateName")
    /**
     * The aggregate_namespace of this rest_operation_dependency.
     */
    override val aggregateNamespace: String
        get() = getOrThrow("aggregateNamespace")
    /**
     * The method_name of this rest_operation_dependency.
     */
    override val methodName: String
        get() = getOrThrow("methodName")
    /**
     * The aggregate of this rest_operation_dependency.
     */
    override val aggregate: Aggregate by lazy {
        AggregateRecord.from(_context).find {
            it.name == aggregateName &&
            it.namespace == aggregateNamespace
        } ?: throw IllegalStateException(
            "There is no aggregate which meets the following condition(s): "
            + "RestOperationDependency.aggregate_name == aggregate.name (=$aggregateName) "
            + "RestOperationDependency.aggregate_namespace == aggregate.namespace (=$aggregateNamespace) "
            + "Possible values are: " + AggregateRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * The access_method of this rest_operation_dependency.
     */
    override val accessMethod: AggregateAccessMethod by lazy {
        aggregate.accessMethods.find{ it.name == methodName }!!
    }
    /**
     * The response_mapping of this rest_operation_dependency.
     */
    override val responseMapping: List<RestOperationResponseMapping> by lazy {
        RestOperationResponseMappingRecord.from(_record.getList("response_mapping", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a rest_operation_dependency or not.
     */
    override val isaRestOperationDependency: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllRestOperationDependencies {
            return _context.get("rest_operation_dependencies") as AllRestOperationDependencies
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            RestOperationDependencyRecord(record, _context)
    }
}
