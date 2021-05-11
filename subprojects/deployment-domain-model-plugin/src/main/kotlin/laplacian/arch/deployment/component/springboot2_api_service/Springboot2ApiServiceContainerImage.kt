package laplacian.arch.deployment.component.springboot2_api_service
import laplacian.arch.backend.api.Service
import laplacian.arch.deployment.component.MavenArtifact

import laplacian.arch.deployment.component.container.ContainerImage

import laplacian.util.*

/**
 * An entity describing a springboot2_api_service_container_image.
 */
interface Springboot2ApiServiceContainerImage : ContainerImage {
    /**
     * The function_model_name of this springboot2_api_service_container_image.
     */
    val functionModelName: String
    /**
     * The container_base_image of this springboot2_api_service_container_image.
     */
    val containerBaseImage: String
    /**
     * The gradle_version of this springboot2_api_service_container_image.
     */
    val gradleVersion: String
    /**
     * The jdk_major_version of this springboot2_api_service_container_image.
     */
    val jdkMajorVersion: String
    /**
     * The kotlin_version of this springboot2_api_service_container_image.
     */
    val kotlinVersion: String
    /**
     * The kotlin_coroutine_version of this springboot2_api_service_container_image.
     */
    val kotlinCoroutineVersion: String
    /**
     * The reactor_kotlin_extension_version of this springboot2_api_service_container_image.
     */
    val reactorKotlinExtensionVersion: String
    /**
     * The r2dbc_postgres_driver_version of this springboot2_api_service_container_image.
     */
    val r2dbcPostgresDriverVersion: String
    /**
     * The oracle_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    val oracleJdbcDriverVersion: String
    /**
     * The postgres_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    val postgresJdbcDriverVersion: String
    /**
     * The mysql_jdbc_driver_version of this springboot2_api_service_container_image.
     */
    val mysqlJdbcDriverVersion: String
    /**
     * The spring_version of this springboot2_api_service_container_image.
     */
    val springVersion: String
    /**
     * The reactor_version of this springboot2_api_service_container_image.
     */
    val reactorVersion: String
    /**
     * The springboot_version of this springboot2_api_service_container_image.
     */
    val springbootVersion: String
    /**
     * The springboot_graphql_webflux_version of this springboot2_api_service_container_image.
     */
    val springbootGraphqlWebfluxVersion: String
    /**
     * The spring_dependency_manager_version of this springboot2_api_service_container_image.
     */
    val springDependencyManagerVersion: String
    /**
     * The graphql_java_version of this springboot2_api_service_container_image.
     */
    val graphqlJavaVersion: String
    /**
     * The graphql_extended_scalar_version of this springboot2_api_service_container_image.
     */
    val graphqlExtendedScalarVersion: String
    /**
     * The springboot_mybatis_version of this springboot2_api_service_container_image.
     */
    val springbootMybatisVersion: String
    /**
     * The elasticsearch_version of this springboot2_api_service_container_image.
     */
    val elasticsearchVersion: String
    /**
     * The springdoc_openapi_version of this springboot2_api_service_container_image.
     */
    val springdocOpenapiVersion: String
    /**
     * The datasource_proxy_version of this springboot2_api_service_container_image.
     */
    val datasourceProxyVersion: String
    /**
     * The repositories of this springboot2_api_service_container_image.
     */
    val repositories: List<String>
    /**
     * The function_model of this springboot2_api_service_container_image.
     */
    val functionModel: Service
    /**
     * The additional_libraries of this springboot2_api_service_container_image.
     */
    val additionalLibraries: List<MavenArtifact>
    /**
     * Returns wether this instance is a springboot2_api_service_container_image or not.
     */
    val isaSpringboot2ApiServiceContainerImage: Boolean
}
