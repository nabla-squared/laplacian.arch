package laplacian.arch.deployment.component


import laplacian.util.*

/**
 * An entity describing a component.
 */
interface Component {
    /**
     * The name of this component.
     */
    val name: String
    /**
     * The type of this component.
     */
    val type: String
    /**
     * The tags of this component.
     */
    val tags: List<String>
    /**
     * Returns wether this instance is a component or not.
     */
    val isaComponent: Boolean
}
