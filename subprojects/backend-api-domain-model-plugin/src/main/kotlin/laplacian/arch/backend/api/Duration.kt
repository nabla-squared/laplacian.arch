package laplacian.arch.backend.api


import laplacian.util.*

/**
 * An entity describing a duration.
 */
interface Duration {
    /**
     * The amount of this duration.
     */
    val amount: String
    /**
     * The unit of this duration.
     */
    val unit: String
    /**
     * Returns wether this instance is a duration or not.
     */
    val isaDuration: Boolean
}
