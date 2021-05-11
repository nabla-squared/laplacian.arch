package laplacian.arch.backend.api.aggregate
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a aggregate.
 */
interface Aggregate {
    /**
     * The name of this aggregate.
     */
    val name: String
    /**
     * The namespace of this aggregate.
     */
    val namespace: String
    /**
     * Defines this aggregate is depends_on_mybatis or not.
     */
    val dependsOnMybatis: Boolean
    /**
     * Defines this aggregate is depends_on_elasticsearch or not.
     */
    val dependsOnElasticsearch: Boolean
    /**
     * The root_entity of this aggregate.
     */
    val rootEntity: Entity
    /**
     * The access_methods of this aggregate.
     */
    val accessMethods: List<AggregateAccessMethod>
    /**
     * Returns wether this instance is a aggregate or not.
     */
    val isaAggregate: Boolean
}
