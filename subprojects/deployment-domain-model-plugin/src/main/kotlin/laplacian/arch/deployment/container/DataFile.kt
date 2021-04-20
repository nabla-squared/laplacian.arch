package laplacian.arch.deployment.container
import laplacian.arch.deployment.Dataset


import laplacian.util.*

/**
 * An entity describing a data_file.
 */
interface DataFile {
    /**
     * The filename of this data_file.
     */
    val filename: String
    /**
     * The dir of this data_file.
     */
    val dir: String
    /**
     * The dataset_name of this data_file.
     */
    val datasetName: String
    /**
     * The dataset of this data_file.
     */
    val dataset: Dataset
    /**
     * Returns wether this instance is a data_file or not.
     */
    val isaDataFile: Boolean
}
