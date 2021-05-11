package laplacian.arch.backend.api.aggregate

import laplacian.arch.backend.api.aggregate.AggregateAccessMethod

import laplacian.util.*

/**
 * An entity describing a mybatis_access_method.
 */
interface MybatisAccessMethod : AggregateAccessMethod {
    /**
     * The datasource_name of this mybatis_access_method.
     */
    val datasourceName: String?
    /**
     * The statement_type of this mybatis_access_method.
     */
    val statementType: String
    /**
     * The statement of this mybatis_access_method.
     */
    val statement: String
    /**
     * Returns wether this instance is a mybatis_access_method or not.
     */
    val isaMybatisAccessMethod: Boolean
}
