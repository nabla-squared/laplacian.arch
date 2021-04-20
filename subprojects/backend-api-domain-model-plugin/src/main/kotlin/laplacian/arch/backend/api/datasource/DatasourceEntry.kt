package laplacian.arch.backend.api.datasource


import laplacian.util.*

/**
 * An entity describing a datasource_entry.
 */
interface DatasourceEntry {
    /**
     * The name of this datasource_entry.
     */
    val name: String
    /**
     * The datasource of this datasource_entry.
     */
    val datasource: Datasource
    /**
     * Returns wether this instance is a datasource_entry or not.
     */
    val isaDatasourceEntry: Boolean
}
