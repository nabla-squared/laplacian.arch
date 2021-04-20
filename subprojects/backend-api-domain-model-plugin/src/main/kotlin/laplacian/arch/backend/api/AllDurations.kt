package laplacian.arch.backend.api
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All durations.
 */
class AllDurations(
    list: List<Duration>,
    val context: Context
) : List<Duration> by list {
}
