package laplacian.arch.backend.api.datasource


import laplacian.util.*

/**
 * A *DataSource* represents an interface through which a client application access to a data store.
This includes the following models.
- The entity that the datastore exposes to the client
- Statement issued by the client to the datastore

 */
interface Datasource {
    /**
     * The name of this datasource.
     */
    val name: String?
    /**
     * The description of this datasource.
     */
    val description: String
    /**
     * The db_type of this datasource.
     */
    val dbType: String
    /**
     * Defines this datasource is non_blocking or not.
     */
    val nonBlocking: Boolean
    /**
     * Returns wether this instance is a datasource or not.
     */
    val isaDatasource: Boolean
}
