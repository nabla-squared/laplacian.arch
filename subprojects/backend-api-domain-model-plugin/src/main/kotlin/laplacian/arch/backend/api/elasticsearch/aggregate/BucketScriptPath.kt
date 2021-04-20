package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a bucket_script_path.
 */
interface BucketScriptPath {
    /**
     * The name of this bucket_script_path.
     */
    val name: String
    /**
     * The path of this bucket_script_path.
     */
    val path: String
    /**
     * Returns wether this instance is a bucket_script_path or not.
     */
    val isaBucketScriptPath: Boolean
}
