package laplacian.arch.backend.api.mybatis
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource
import laplacian.arch.backend.api.datasource.DatasourceRecord
import laplacian.arch.backend.api.graphql.GraphqlField
import laplacian.arch.backend.api.graphql.GraphqlFieldRecord

import laplacian.arch.backend.api.graphql.GraphqlFieldFetcherRecord

import laplacian.generate.util.*
/**
 * An entity describing a mybatis_fetcher.
 */
data class MybatisFetcherRecord (
    private val __record: Record,
    private val _context: Context,
    override val graphqlField: GraphqlField,
    private val _record: Record = __record.normalizeCamelcase()
): GraphqlFieldFetcherRecord(__record, _context, graphqlField), MybatisFetcher {

    /**
     * The datasource_name of this mybatis_fetcher.
     */
    override val datasourceName: String
        get() = getOrThrow("datasourceName")
    /**
     * The statement_type of this mybatis_fetcher.
     */
    override val statementType: String
        get() = getOrThrow("statementType")
    /**
     * The statement of this mybatis_fetcher.
     */
    override val statement: String
        get() = getOrThrow("statement")
    /**
     * The datasource of this mybatis_fetcher.
     */
    override val datasource: Datasource by lazy {
        DatasourceRecord.from(_context).find {
            it.name == datasourceName
        } ?: throw IllegalStateException(
            "There is no datasource which meets the following condition(s): "
            + "MybatisFetcher.datasource_name == datasource.name (=$datasourceName) "
            + "Possible values are: " + DatasourceRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a mybatis_fetcher or not.
     */
    override val isaMybatisFetcher: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, graphqlField: GraphqlField) = records
            .map { from(it, _context, graphqlField = graphqlField) }

        fun from(record: Record, _context: Context, graphqlField: GraphqlField) =
            MybatisFetcherRecord(record, _context, graphqlField = graphqlField)
    }
}
