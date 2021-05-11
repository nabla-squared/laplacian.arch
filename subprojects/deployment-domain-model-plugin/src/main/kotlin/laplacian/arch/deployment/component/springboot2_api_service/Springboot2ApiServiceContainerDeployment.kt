package laplacian.arch.deployment.component.springboot2_api_service
import laplacian.arch.deployment.datasource.DatasourceConfiguration
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchClientConfiguration

import laplacian.arch.deployment.container.ContainerDeployment

import laplacian.util.*

/**
 * An entity describing a springboot2_api_service_container_deployment.
 */
interface Springboot2ApiServiceContainerDeployment : ContainerDeployment {
    /**
     * The http_port of this springboot2_api_service_container_deployment.
     */
    val httpPort: Int
    /**
     * Defines this springboot2_api_service_container_deployment is enable_jmx or not.
     */
    val enableJmx: Boolean
    /**
     * The jmx_port of this springboot2_api_service_container_deployment.
     */
    val jmxPort: Int
    /**
     * Defines this springboot2_api_service_container_deployment is enable_debug or not.
     */
    val enableDebug: Boolean
    /**
     * The debug_port of this springboot2_api_service_container_deployment.
     */
    val debugPort: Int
    /**
     * The datasources of this springboot2_api_service_container_deployment.
     */
    val datasources: List<DatasourceConfiguration>
    /**
     * The elasticsearch_clients of this springboot2_api_service_container_deployment.
     */
    val elasticsearchClients: List<ElasticsearchClientConfiguration>
    /**
     * Returns wether this instance is a springboot2_api_service_container_deployment or not.
     */
    val isaSpringboot2ApiServiceContainerDeployment: Boolean
}
