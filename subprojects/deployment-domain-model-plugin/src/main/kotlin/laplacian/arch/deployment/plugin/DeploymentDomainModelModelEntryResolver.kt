package laplacian.arch.deployment.plugin
import org.pf4j.Extension
import laplacian.generate.ModelEntryResolver
import laplacian.generate.ExecutionContext
import laplacian.arch.deployment.component.AllComponents
import laplacian.arch.deployment.component.ComponentRecord
import laplacian.arch.deployment.component.container.AllEnvironmentVariableDefinitions
import laplacian.arch.deployment.component.container.EnvironmentVariableDefinitionRecord
import laplacian.arch.deployment.component.elasticsearch.AllElasticsearchClientConfigurations
import laplacian.arch.deployment.component.elasticsearch.ElasticsearchClientConfigurationRecord
import laplacian.arch.deployment.component.elasticsearch.AllInitialIndexDatas
import laplacian.arch.deployment.component.elasticsearch.InitialIndexDataRecord
import laplacian.arch.deployment.component.elasticsearch.AllConfigurationFiles
import laplacian.arch.deployment.component.elasticsearch.ConfigurationFileRecord
import laplacian.arch.deployment.component.AllMavenArtifacts
import laplacian.arch.deployment.component.MavenArtifactRecord
import laplacian.arch.deployment.component.redis.AllRedisContainerDeployments
import laplacian.arch.deployment.component.redis.RedisContainerDeploymentRecord
import laplacian.arch.deployment.component.redis.AllRedisContainerImages
import laplacian.arch.deployment.component.redis.RedisContainerImageRecord
import laplacian.arch.deployment.AllDatasets
import laplacian.arch.deployment.DatasetRecord
import laplacian.arch.deployment.container.AllDataFiles
import laplacian.arch.deployment.container.DataFileRecord
import laplacian.arch.deployment.container.AllInitialTableDatas
import laplacian.arch.deployment.container.InitialTableDataRecord
import laplacian.arch.deployment.datasource.AllDatasourceConfigurations
import laplacian.arch.deployment.datasource.DatasourceConfigurationRecord
import laplacian.arch.deployment.AllEnvironments
import laplacian.arch.deployment.EnvironmentRecord

import laplacian.generate.util.*

@Extension
class DeploymentDomainModelModelEntryResolver: ModelEntryResolver {

    override fun resolves(key: String, model: Map<String, Any?>): Boolean {
        return arrayOf(
            "components",
            "environment_variable_definitions",
            "elasticsearch_client_configurations",
            "initial_index_datas",
            "configuration_files",
            "maven_artifacts",
            "redis_container_deployments",
            "redis_container_images",
            "datasets",
            "data_files",
            "initial_table_datas",
            "datasource_configurations",
            "environments"
        ).any { it == key }
    }

    override fun resolve(key: String, model: Map<String, Any?>, context: ExecutionContext): Any? {
        return when (key) {
            "components" -> AllComponents(
                model.getList<Record>("components", emptyList())
                     .mergeWithKeys("name")
                     .let{ ComponentRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "environment_variable_definitions" -> AllEnvironmentVariableDefinitions(
                model.getList<Record>("environment_variable_definitions", emptyList())
                     .mergeWithKeys("name")
                     .let{ EnvironmentVariableDefinitionRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_client_configurations" -> AllElasticsearchClientConfigurations(
                model.getList<Record>("elasticsearch_client_configurations", emptyList())
                     .mergeWithKeys("name")
                     .let{ ElasticsearchClientConfigurationRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "initial_index_datas" -> AllInitialIndexDatas(
                model.getList<Record>("initial_index_datas", emptyList())
                     .mergeWithKeys("index_model_name")
                     .let{ InitialIndexDataRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "configuration_files" -> AllConfigurationFiles(
                model.getList<Record>("configuration_files", emptyList())
                     .mergeWithKeys("path")
                     .let{ ConfigurationFileRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "maven_artifacts" -> AllMavenArtifacts(
                model.getList<Record>("maven_artifacts", emptyList())
                     .mergeWithKeys("group", "name")
                     .let{ MavenArtifactRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "redis_container_deployments" -> AllRedisContainerDeployments(
                model.getList<Record>("redis_container_deployments", emptyList())
                     .mergeWithKeys()
                     .let{ RedisContainerDeploymentRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "redis_container_images" -> AllRedisContainerImages(
                model.getList<Record>("redis_container_images", emptyList())
                     .mergeWithKeys()
                     .let{ RedisContainerImageRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "datasets" -> AllDatasets(
                model.getList<Record>("datasets", emptyList())
                     .mergeWithKeys("name")
                     .let{ DatasetRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "data_files" -> AllDataFiles(
                model.getList<Record>("data_files", emptyList())
                     .mergeWithKeys("filename")
                     .let{ DataFileRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "initial_table_datas" -> AllInitialTableDatas(
                model.getList<Record>("initial_table_datas", emptyList())
                     .mergeWithKeys("table_model_name")
                     .let{ InitialTableDataRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "datasource_configurations" -> AllDatasourceConfigurations(
                model.getList<Record>("datasource_configurations", emptyList())
                     .mergeWithKeys("name")
                     .let{ DatasourceConfigurationRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "environments" -> AllEnvironments(
                model.getList<Record>("environments", emptyList())
                     .mergeWithKeys("name")
                     .let{ EnvironmentRecord.from(it, context.currentModel) },
                context.currentModel
            )
            else -> throw IllegalArgumentException("Unknown key: $key")
        }
    }
}
