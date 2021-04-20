package laplacian.arch.deployment.component
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a maven_artifact.
 */
data class MavenArtifactRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): MavenArtifact, Record by _record {

    /**
     * The group of this maven_artifact.
     */
    override val group: String
        get() = getOrThrow("group")
    /**
     * The name of this maven_artifact.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The version of this maven_artifact.
     */
    override val version: String
        get() = getOrThrow("version")
    /**
     * The gradle_dependency_entry of this maven_artifact.
     */
    override val gradleDependencyEntry: String
        get() = "${group}:${name}:${version}"
    /**
     * Returns wether this instance is a maven_artifact or not.
     */
    override val isaMavenArtifact: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllMavenArtifacts {
            return _context.get("maven_artifacts") as AllMavenArtifacts
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            MavenArtifactRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MavenArtifactRecord) return false
        if (group != other.group) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = group.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "MavenArtifactRecord(" +
            "group=$group, " +
            "name=$name" +
        ")"
    }
}
