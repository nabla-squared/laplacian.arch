package laplacian.arch.deployment.container
import com.github.jknack.handlebars.Context
import laplacian.metamodel.Entity

import laplacian.util.*

/**
 * All initial_table_datas.
 */
class AllInitialTableDatas(
    list: List<InitialTableData>,
    val context: Context
) : List<InitialTableData> by list {
}
