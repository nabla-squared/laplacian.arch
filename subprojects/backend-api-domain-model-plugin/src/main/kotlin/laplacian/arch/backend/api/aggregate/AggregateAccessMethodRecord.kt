package laplacian.arch.backend.api.aggregate
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.aggregate.Aggregate

import laplacian.arch.backend.api.ApiCallArgument
import laplacian.arch.backend.api.ApiCallArgumentRecord
import laplacian.metamodel.Entity
import laplacian.metamodel.EntityRecord


import laplacian.arch.backend.api.aggregate.ElasticsearchAccessMethodRecord
import laplacian.arch.backend.api.aggregate.MybatisAccessMethodRecord

import laplacian.generate.util.*
/**
 * An entity describing a aggregate_access_method.
 */
open class AggregateAccessMethodRecord (
    private val __record: Record,
    private val _context: Context,
    override val aggregate: Aggregate,
    private val _record: Record = __record.normalizeCamelcase()
): AggregateAccessMethod, Record by _record {

    /**
     * The name of this aggregate_access_method.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The type of this aggregate_access_method.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The description of this aggregate_access_method.
     */
    override val description: String
        get() = getOrThrow("description") {
            "${name}"
        }
    /**
     * Defines this aggregate_access_method is multiple or not.
     */
    override val multiple: Boolean
        get() = getOrThrow("multiple") {
            true
        }
    /**
     * Defines this aggregate_access_method is with_pagination or not.
     */
    override val withPagination: Boolean
        get() = getOrThrow("withPagination") {
            false
        }
    /**
     * The record_model_name of this aggregate_access_method.
     */
    override val recordModelName: String?
        by _record
    /**
     * The record_model_namespace of this aggregate_access_method.
     */
    override val recordModelNamespace: String?
        by _record
    /**
     * The record_class_name of this aggregate_access_method.
     */
    override val recordClassName: String
        get() = (recordModelName ?: aggregate.name).upperCamelize()
    /**
     * The result_class_name_in_java of this aggregate_access_method.
     */
    override val resultClassNameInJava: String
        get() = if (multiple) "List<${recordClassName}>" else recordClassName
    /**
     * The arguments of this aggregate_access_method.
     */
    override val arguments: List<ApiCallArgument> by lazy {
        ApiCallArgumentRecord.from(_record.getList("arguments", emptyList()), _context)
    }
    /**
     * The record_model of this aggregate_access_method.
     */
    override val recordModel: Entity? by lazy {
        EntityRecord.from(_context).find {
            it.name == recordModelName &&
            it.namespace == recordModelNamespace
        }
    }
    /**
     * Returns wether this instance is a aggregate_access_method or not.
     */
    override val isaAggregateAccessMethod: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, aggregate: Aggregate) = records
            .mergeWithKeys("name")
            .map { from(it, _context, aggregate = aggregate) }

        fun from(record: Record, _context: Context, aggregate: Aggregate) =
            when (val type = record["type"]) {
                "elasticsearch" -> ElasticsearchAccessMethodRecord(record, _context, aggregate = aggregate)
                "mybatis" -> MybatisAccessMethodRecord(record, _context, aggregate = aggregate)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [elasticsearch, mybatis]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregateAccessMethodRecord) return false
        if (aggregate != other.aggregate) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = aggregate.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "AggregateAccessMethodRecord(" +
            "aggregate=$aggregate, " +
            "name=$name" +
        ")"
    }
}
