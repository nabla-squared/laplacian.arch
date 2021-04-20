package laplacian.arch.backend.api.graphql
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity
import laplacian.arch.backend.api.ConfigurationBinding
import laplacian.arch.backend.api.mybatis.MybatisFetcher

import laplacian.util.*

/**
 * All graphql_types.
 */
class AllGraphqlTypes(
    list: List<GraphqlType>,
    val context: Context
) : List<GraphqlType> by list {
}
