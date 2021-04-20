package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All field_sorts.
 */
class AllFieldSorts(
    list: List<FieldSort>,
    val context: Context
) : List<FieldSort> by list {
}
