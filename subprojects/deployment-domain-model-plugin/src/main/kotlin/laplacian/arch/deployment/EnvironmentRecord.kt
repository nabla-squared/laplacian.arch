package laplacian.arch.deployment
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Deployment

import laplacian.arch.deployment.component.Component
import laplacian.arch.deployment.component.ComponentRecord
import laplacian.arch.deployment.container.ContainerDeployment
import laplacian.arch.deployment.container.ContainerDeploymentRecord
import laplacian.arch.deployment.component.container.ContainerImage
import laplacian.arch.deployment.component.container.ContainerImageRecord



import laplacian.generate.util.*
/**
 * An entity describing a environment.
 */
data class EnvironmentRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): Environment, Record by _record {

    /**
     * The name of this environment.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The tier of this environment.
     */
    override val tier: String
        get() = getOrThrow("tier")
    /**
     * Defines this environment is uses_locally_built_container_images or not.
     */
    override val usesLocallyBuiltContainerImages: Boolean
        get() = getOrThrow("usesLocallyBuiltContainerImages") {
            listOf("development", "local").contains(tier)
        }
    /**
     * Defines this environment is uses_gcp or not.
     */
    override val usesGcp: Boolean
        get() = getOrThrow("usesGcp") {
            deployments.any{ deployment ->
                listOf("gcp", "gce").any {
                  deployment.type.contains("_${it}_")
                }
            }
        }
    /**
     * The deployments of this environment.
     */
    override val deployments: List<Deployment> by lazy {
        DeploymentRecord.from(_record.getList("deployments", emptyList()), _context, this)
    }
    /**
     * The components of this environment.
     */
    override val components: List<Component> by lazy {
        deployments.map{ it.component }.distinct()
    }
    /**
     * The container_deployments of this environment.
     */
    override val containerDeployments: List<ContainerDeployment> by lazy {
        deployments.filterIsInstance<ContainerDeployment>()
    }
    /**
     * The container_images of this environment.
     */
    override val containerImages: List<ContainerImage> by lazy {
        components.filterIsInstance<ContainerImage>()
    }
    /**
     * Returns wether this instance is a environment or not.
     */
    override val isaEnvironment: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllEnvironments {
            return _context.get("environments") as AllEnvironments
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            EnvironmentRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EnvironmentRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "EnvironmentRecord(" +
            "name=$name" +
        ")"
    }
}
