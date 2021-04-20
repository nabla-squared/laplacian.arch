package laplacian.arch.deployment.component


import laplacian.util.*

/**
 * An entity describing a maven_artifact.
 */
interface MavenArtifact {
    /**
     * The group of this maven_artifact.
     */
    val group: String
    /**
     * The name of this maven_artifact.
     */
    val name: String
    /**
     * The version of this maven_artifact.
     */
    val version: String
    /**
     * The gradle_dependency_entry of this maven_artifact.
     */
    val gradleDependencyEntry: String
    /**
     * Returns wether this instance is a maven_artifact or not.
     */
    val isaMavenArtifact: Boolean
}
