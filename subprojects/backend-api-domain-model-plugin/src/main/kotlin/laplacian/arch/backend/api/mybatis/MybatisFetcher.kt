package laplacian.arch.backend.api.mybatis
import laplacian.arch.backend.api.datasource.Datasource

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcher

import laplacian.util.*

/**
 * An entity describing a mybatis_fetcher.
 */
interface MybatisFetcher : GraphqlFieldFetcher {
    /**
     * The datasource_name of this mybatis_fetcher.
     */
    val datasourceName: String
    /**
     * The statement_type of this mybatis_fetcher.
     */
    val statementType: String
    /**
     * The statement of this mybatis_fetcher.
     */
    val statement: String
    /**
     * The datasource of this mybatis_fetcher.
     */
    val datasource: Datasource
    /**
     * Returns wether this instance is a mybatis_fetcher or not.
     */
    val isaMybatisFetcher: Boolean
}
