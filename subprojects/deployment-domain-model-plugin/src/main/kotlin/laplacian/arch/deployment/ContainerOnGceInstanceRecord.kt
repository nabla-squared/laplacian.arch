package laplacian.arch.deployment
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.Environment


import laplacian.arch.deployment.DeploymentRecord

import laplacian.generate.util.*
/**
 * An entity describing a container_on_gce_instance.
 */
data class ContainerOnGceInstanceRecord (
    private val __record: Record,
    private val _context: Context,
    override val environment: Environment,
    private val _record: Record = __record.normalizeCamelcase()
): DeploymentRecord(__record, _context, environment), ContainerOnGceInstance {

    /**
     * The machine_type of this container_on_gce_instance.
     */
    override val machineType: String
        get() = getOrThrow("machineType") {
            "f1-micro"
        }
    /**
     * Returns wether this instance is a container_on_gce_instance or not.
     */
    override val isaContainerOnGceInstance: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context, environment: Environment) = records
            .mergeWithKeys("name")
            .map { from(it, _context, environment = environment) }

        fun from(record: Record, _context: Context, environment: Environment) =
            ContainerOnGceInstanceRecord(record, _context, environment = environment)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContainerOnGceInstanceRecord) return false
        if (environment != other.environment) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = environment.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ContainerOnGceInstanceRecord(" +
            "environment=$environment, " +
            "name=$name" +
        ")"
    }
}
