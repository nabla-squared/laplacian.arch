package laplacian.arch.backend.api.data_file


import laplacian.util.*

/**
 * An entity describing a data_file.
 */
interface DataFile {
    /**
     * The name of this data_file.
     */
    val name: String
    /**
     * The description of this data_file.
     */
    val description: String
    /**
     * The format of this data_file.
     */
    val format: String
    /**
     * The default_path of this data_file.
     */
    val defaultPath: String
    /**
     * Returns wether this instance is a data_file or not.
     */
    val isaDataFile: Boolean
}
