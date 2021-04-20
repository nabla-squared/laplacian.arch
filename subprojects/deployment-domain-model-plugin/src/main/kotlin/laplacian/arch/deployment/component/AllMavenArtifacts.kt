package laplacian.arch.deployment.component
import com.github.jknack.handlebars.Context

import laplacian.util.*

/**
 * All maven_artifacts.
 */
class AllMavenArtifacts(
    list: List<MavenArtifact>,
    val context: Context
) : List<MavenArtifact> by list {
}
