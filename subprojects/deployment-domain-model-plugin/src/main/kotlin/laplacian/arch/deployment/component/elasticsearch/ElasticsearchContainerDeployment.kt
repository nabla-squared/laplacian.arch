package laplacian.arch.deployment.component.elasticsearch

import laplacian.arch.deployment.container.ContainerDeployment

import laplacian.util.*

/**
 * An entity describing a elasticsearch_container_deployment.
 */
interface ElasticsearchContainerDeployment : ContainerDeployment {
    /**
     * The port of this elasticsearch_container_deployment.
     */
    val port: Int
    /**
     * The initial_data of this elasticsearch_container_deployment.
     */
    val initialData: List<InitialIndexData>
    /**
     * Returns wether this instance is a elasticsearch_container_deployment or not.
     */
    val isaElasticsearchContainerDeployment: Boolean
}
