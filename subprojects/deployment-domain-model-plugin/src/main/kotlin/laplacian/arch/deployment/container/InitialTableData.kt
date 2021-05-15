package laplacian.arch.deployment.container
import laplacian.metamodel.Entity


import laplacian.util.*

/**
 * An entity describing a initial_table_data.
 */
interface InitialTableData {
    /**
     * The table_name of this initial_table_data.
     */
    val tableName: String
    /**
     * The table_model_name of this initial_table_data.
     */
    val tableModelName: String
    /**
     * The schema_name of this initial_table_data.
     */
    val schemaName: String?
    /**
     * The table_model of this initial_table_data.
     */
    val tableModel: Entity
    /**
     * Returns wether this instance is a initial_table_data or not.
     */
    val isaInitialTableData: Boolean
}
