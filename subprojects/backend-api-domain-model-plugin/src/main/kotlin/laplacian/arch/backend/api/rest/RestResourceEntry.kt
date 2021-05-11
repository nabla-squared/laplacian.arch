package laplacian.arch.backend.api.rest


import laplacian.util.*

/**
 * An entity describing a rest_resource_entry.
 */
interface RestResourceEntry {
    /**
     * The name of this rest_resource_entry.
     */
    val name: String
    /**
     * The namespace of this rest_resource_entry.
     */
    val namespace: String
    /**
     * The rest_resource of this rest_resource_entry.
     */
    val restResource: RestResource
    /**
     * Returns wether this instance is a rest_resource_entry or not.
     */
    val isaRestResourceEntry: Boolean
}
