package laplacian.arch.deployment.datasource
import laplacian.arch.backend.api.datasource.Datasource


import laplacian.util.*

/**
 * An entity describing a datasource_configuration.
 */
interface DatasourceConfiguration {
    /**
     * The name of this datasource_configuration.
     */
    val name: String
    /**
     * The type of this datasource_configuration.
     */
    val type: String
    /**
     * The datasource of this datasource_configuration.
     */
    val datasource: Datasource
    /**
     * Returns wether this instance is a datasource_configuration or not.
     */
    val isaDatasourceConfiguration: Boolean
}
