package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All bucket_script_paths.
 */
class AllBucketScriptPaths(
    list: List<BucketScriptPath>,
    val context: Context
) : List<BucketScriptPath> by list {
}
