package laplacian.arch.deployment.component.springboot2_api_service
import com.github.jknack.handlebars.Context
import laplacian.arch.backend.api.Service
import laplacian.arch.backend.api.ServiceRecord
import laplacian.arch.deployment.component.MavenArtifact
import laplacian.arch.deployment.component.MavenArtifactRecord

import laplacian.arch.deployment.component.container.ContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a springboot2_api_service_container_image.
 */
data class Springboot2ApiServiceContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerImageRecord(__record, _context), Springboot2ApiServiceContainerImage {

    /**
     * The function_model_name of this springboot2_api_service_container_image.
     */
    override val functionModelName: String
        get() = getOrThrow("functionModelName")
    /**
     * Defines this springboot2_api_service_container_image is custom_built or not.
     */
    override val customBuilt: Boolean
        get() = true
    /**
     * The container_base_image of this springboot2_api_service_container_image.
     */
    override val containerBaseImage: String
        get() = getOrThrow("containerBaseImage") {
            "adoptopenjdk:11-jdk-hotspot"
        }
    /**
     * The gradle_version of this springboot2_api_service_container_image.
     */
    override val gradleVersion: String
        get() = getOrThrow("gradleVersion") {
            "6.6.1"
        }
    /**
     * The jdk_major_version of this springboot2_api_service_container_image.
     */
    override val jdkMajorVersion: String
        get() = getOrThrow("jdkMajorVersion") {
            "11"
        }
    /**
     * The kotlin_version of this springboot2_api_service_container_image.
     */
    override val kotlinVersion: String
        get() = getOrThrow("kotlinVersion") {
            "1.4.30"
        }
    /**
     * The kotlin_coroutine_version of this springboot2_api_service_container_image.
     */
    override val kotlinCoroutineVersion: String
        get() = getOrThrow("kotlinCoroutineVersion") {
            "1.4.2"
        }
    /**
     * The reactor_kotlin_extension_version of this springboot2_api_service_container_image.
     */
    override val reactorKotlinExtensionVersion: String
        get() = getOrThrow("reactorKotlinExtensionVersion") {
            "1.1.2"
        }
    /**
     * The r2dbc_postgres_driver_version of this springboot2_api_service_container_image.
     */
    override val r2dbcPostgresDriverVersion: String
        get() = getOrThrow("r2dbcPostgresDriverVersion") {
            "0.8.3.RELEASE"
        }
    /**
     * The oracle_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    override val oracleJdbcDriverVersion: String
        get() = getOrThrow("oracleJdbcDriverVersion") {
            "21.1.0.0"
        }
    /**
     * The postgres_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    override val postgresJdbcDriverVersion: String
        get() = getOrThrow("postgresJdbcDriverVersion") {
            "42.2.18"
        }
    /**
     * The mysql_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    override val mysqlJdbcDriverVersion: String
        get() = getOrThrow("mysqlJdbcDriverVersion") {
            "8.0.23"
        }
    /**
     * The spring_version of this springboot2_api_service_container_image.
     */
    override val springVersion: String
        get() = getOrThrow("springVersion") {
            "5.3.6.RELEASE"
        }
    /**
     * The reactor_version of this springboot2_api_service_container_image.
     */
    override val reactorVersion: String
        get() = getOrThrow("reactorVersion") {
            "3.2.5.RELEASE"
        }
    /**
     * The springboot_version of this springboot2_api_service_container_image.
     */
    override val springbootVersion: String
        get() = getOrThrow("springbootVersion") {
            "2.4.5"
        }
    /**
     * The springboot_graphql_webflux_version of this springboot2_api_service_container_image.
     */
    override val springbootGraphqlWebfluxVersion: String
        get() = getOrThrow("springbootGraphqlWebfluxVersion") {
            "2.0"
        }
    /**
     * The spring_dependency_manager_version of this springboot2_api_service_container_image.
     */
    override val springDependencyManagerVersion: String
        get() = getOrThrow("springDependencyManagerVersion") {
            "1.0.11.RELEASE"
        }
    /**
     * The graphql_java_version of this springboot2_api_service_container_image.
     */
    override val graphqlJavaVersion: String
        get() = getOrThrow("graphqlJavaVersion") {
            "15.0"
        }
    /**
     * The graphql_extended_scalar_version of this springboot2_api_service_container_image.
     */
    override val graphqlExtendedScalarVersion: String
        get() = getOrThrow("graphqlExtendedScalarVersion") {
            "1.0.1"
        }
    /**
     * The springboot_mybatis_version of this springboot2_api_service_container_image.
     */
    override val springbootMybatisVersion: String
        get() = getOrThrow("springbootMybatisVersion") {
            "2.1.4"
        }
    /**
     * The elasticsearch_version of this springboot2_api_service_container_image.
     */
    override val elasticsearchVersion: String
        get() = getOrThrow("elasticsearchVersion") {
            "7.12.1"
        }
    /**
     * The springdoc_openapi_version of this springboot2_api_service_container_image.
     */
    override val springdocOpenapiVersion: String
        get() = getOrThrow("springdocOpenapiVersion") {
            "1.5.7"
        }
    /**
     * The datasource_proxy_version of this springboot2_api_service_container_image.
     */
    override val datasourceProxyVersion: String
        get() = getOrThrow("datasourceProxyVersion") {
            "1.7"
        }
    /**
     * The repositories of this springboot2_api_service_container_image.
     */
    override val repositories: List<String>
        get() = getOrThrow("repositories") {
            listOf(
                "mavenCentral()"
            )
        }
    /**
     * The function_model of this springboot2_api_service_container_image.
     */
    override val functionModel: Service by lazy {
        ServiceRecord.from(_context).find {
            it.name == functionModelName
        } ?: throw IllegalStateException(
            "There is no service which meets the following condition(s): "
            + "Springboot2ApiServiceContainerImage.function_model_name == service.name (=$functionModelName) "
            + "Possible values are: " + ServiceRecord.from(_context).map {
              "(${ it.name })"
            }.joinToString()
        )
    }
    /**
     * The additional_libraries of this springboot2_api_service_container_image.
     */
    override val additionalLibraries: List<MavenArtifact> by lazy {
        MavenArtifactRecord.from(_record.getList("additional_libraries", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a springboot2_api_service_container_image or not.
     */
    override val isaSpringboot2ApiServiceContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            Springboot2ApiServiceContainerImageRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Springboot2ApiServiceContainerImageRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Springboot2ApiServiceContainerImageRecord(" +
            "name=$name" +
        ")"
    }
}
