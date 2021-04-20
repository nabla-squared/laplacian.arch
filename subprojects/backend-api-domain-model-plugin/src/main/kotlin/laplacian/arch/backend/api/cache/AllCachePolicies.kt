package laplacian.arch.backend.api.cache
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.Duration
import laplacian.arch.backend.api.ConfigurationBinding

import laplacian.util.*

/**
 * All cache_policies.
 */
class AllCachePolicies(
    list: List<CachePolicy>,
    val context: Context
) : List<CachePolicy> by list {
}
