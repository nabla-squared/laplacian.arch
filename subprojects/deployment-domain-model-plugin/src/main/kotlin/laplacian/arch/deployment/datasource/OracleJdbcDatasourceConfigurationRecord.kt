package laplacian.arch.deployment.datasource
import com.github.jknack.handlebars.Context

import laplacian.arch.deployment.datasource.JdbcDatasourceConfigurationRecord

import laplacian.generate.util.*
/**
 * An entity describing a oracle_jdbc_datasource_configuration.
 */
data class OracleJdbcDatasourceConfigurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): JdbcDatasourceConfigurationRecord(__record, _context), OracleJdbcDatasourceConfiguration {

    /**
     * The driver_class_name of this oracle_jdbc_datasource_configuration.
     */
    override val driverClassName: String
        get() = getOrThrow("driverClassName") {
            "oracle.jdbc.OracleDriver"
        }
    /**
     * Returns wether this instance is a oracle_jdbc_datasource_configuration or not.
     */
    override val isaOracleJdbcDatasourceConfiguration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            OracleJdbcDatasourceConfigurationRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OracleJdbcDatasourceConfigurationRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "OracleJdbcDatasourceConfigurationRecord(" +
            "name=$name" +
        ")"
    }
}
