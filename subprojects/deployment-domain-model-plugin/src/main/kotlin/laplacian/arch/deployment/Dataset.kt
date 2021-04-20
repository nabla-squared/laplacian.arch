package laplacian.arch.deployment


import laplacian.util.*

/**
 * An entity describing a dataset.
 */
interface Dataset {
    /**
     * The name of this dataset.
     */
    val name: String
    /**
     * The tags of this dataset.
     */
    val tags: List<String>
    /**
     * The content of this dataset.
     */
    val content: List<Any>
    /**
     * Returns wether this instance is a dataset or not.
     */
    val isaDataset: Boolean
}
