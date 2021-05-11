package laplacian.arch.backend.api
import laplacian.arch.backend.api.datasource.Datasource


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
     * Defines this datasource_entry is primary or not.
     */
    val primary: Boolean
    /**
     * The datasource of this datasource_entry.
     */
    val datasource: Datasource
    /**
     * Returns wether this instance is a datasource_entry or not.
     */
    val isaDatasourceEntry: Boolean
}
