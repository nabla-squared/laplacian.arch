package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Dataset
import laplacian.metamodel.Entity

import laplacian.util.*

/**
 * All initial_index_datas.
 */
class AllInitialIndexDatas(
    list: List<InitialIndexData>,
    val context: Context
) : List<InitialIndexData> by list {
}
