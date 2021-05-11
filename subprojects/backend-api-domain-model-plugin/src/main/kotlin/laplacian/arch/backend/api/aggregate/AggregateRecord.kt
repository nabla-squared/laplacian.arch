package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord
import laplacian.arch.backend.api.aggregate.AggregateAccessMethod




import laplacian.generate.util.*
/**
 * An entity describing a aggregate.
 */
data class AggregateRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Aggregate, Record by _record {

    /**
     * The name of this aggregate.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The namespace of this aggregate.
     */
    override val namespace: String
        get() = getOrThrow("namespace")
    /**
     * Defines this aggregate is depends_on_mybatis or not.
     */
    override val dependsOnMybatis: Boolean
        get() = accessMethods.any{ it.type == "mybatis" }
    /**
     * Defines this aggregate is depends_on_elasticsearch or not.
     */
    override val dependsOnElasticsearch: Boolean
        get() = accessMethods.any{ it.type == "elasticsearch" }
    /**
     * The root_entity of this aggregate.
     */
    override val rootEntity: Entity by lazy {
        EntityRecord.from(_context).find {
            it.name == name &&
            it.namespace == namespace
        } ?: throw IllegalStateException(
            "There is no entity which meets the following condition(s): "
            + "Aggregate.name == entity.name (=$name) "
            + "Aggregate.namespace == entity.namespace (=$namespace) "
            + "Possible values are: " + EntityRecord.from(_context).map {
              "(${ it.name },${ it.namespace })"
            }.joinToString()
        )
    }
    /**
     * The access_methods of this aggregate.
     */
    override val accessMethods: List<AggregateAccessMethod> by lazy {
        AggregateAccessMethodRecord.from(_record.getList("access_methods", emptyList()), _context, this)
    }
    /**
     * Returns wether this instance is a aggregate or not.
     */
    override val isaAggregate: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllAggregates {
            return _context.get("aggregates") as AllAggregates
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            AggregateRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregateRecord) return false
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
        return "AggregateRecord(" +
            "name=$name, " +
            "namespace=$namespace" +
        ")"
    }
}
