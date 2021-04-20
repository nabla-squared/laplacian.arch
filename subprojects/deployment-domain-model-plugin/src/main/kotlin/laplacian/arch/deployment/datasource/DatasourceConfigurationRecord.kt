package laplacian.arch.deployment.datasource
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.datasource.Datasource
import laplacian.arch.backend.api.datasource.DatasourceRecord


import laplacian.arch.deployment.datasource.JdbcDatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.MysqlJdbcDatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.OracleJdbcDatasourceConfigurationRecord
import laplacian.arch.deployment.datasource.PostgresJdbcDatasourceConfigurationRecord

import laplacian.generate.util.*
/**
 * An entity describing a datasource_configuration.
 */
open class DatasourceConfigurationRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): DatasourceConfiguration, Record by _record {

    /**
     * The name of this datasource_configuration.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The type of this datasource_configuration.
     */
    override val type: String
        get() = getOrThrow("type")
    /**
     * The datasource of this datasource_configuration.
     */
    override val datasource: Datasource by lazy {
        DatasourceRecord.from(_context).find {
            it.name == name
        } ?: throw IllegalStateException(
            "There is no datasource which meets the following condition(s): "
            + "DatasourceConfiguration.name == datasource.name (=$name) "
            + "Possible values are: " + DatasourceRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * Returns wether this instance is a datasource_configuration or not.
     */
    override val isaDatasourceConfiguration: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllDatasourceConfigurations {
            return _context.get("datasource_configurations") as AllDatasourceConfigurations
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            when (val type = record["type"]) {
                "jdbc_datasource_configuration" -> JdbcDatasourceConfigurationRecord(record, _context)
                "mysql_jdbc" -> MysqlJdbcDatasourceConfigurationRecord(record, _context)
                "oracle_jdbc" -> OracleJdbcDatasourceConfigurationRecord(record, _context)
                "postgres_jdbc" -> PostgresJdbcDatasourceConfigurationRecord(record, _context)
                else -> throw IllegalArgumentException(
                    "The given record has undefined type $type. It is should be one of [jdbc_datasource_configuration, mysql_jdbc, oracle_jdbc, postgres_jdbc]. Record: $record"
                )
            }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DatasourceConfigurationRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "DatasourceConfigurationRecord(" +
            "name=$name" +
        ")"
    }
}
