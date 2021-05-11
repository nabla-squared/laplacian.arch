package laplacian.arch.backend.api.plugin
import org.pf4j.Extension
import laplacian.generate.ModelEntryResolver
import laplacian.generate.ExecutionContext
import laplacian.arch.backend.api.aggregate.AllAggregateEntries
import laplacian.arch.backend.api.aggregate.AggregateEntryRecord
import laplacian.arch.backend.api.aggregate.AllAggregates
import laplacian.arch.backend.api.aggregate.AggregateRecord
import laplacian.arch.backend.api.AllApiCallArguments
import laplacian.arch.backend.api.ApiCallArgumentRecord
import laplacian.arch.backend.api.cache.AllCachePolicies
import laplacian.arch.backend.api.cache.CachePolicyRecord
import laplacian.arch.backend.api.data_file.AllDataFiles
import laplacian.arch.backend.api.data_file.DataFileRecord
import laplacian.arch.backend.api.datasource.AllDatasources
import laplacian.arch.backend.api.datasource.DatasourceRecord
import laplacian.arch.backend.api.AllDurations
import laplacian.arch.backend.api.DurationRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllBucketScriptPaths
import laplacian.arch.backend.api.elasticsearch.aggregate.BucketScriptPathRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllFieldSorts
import laplacian.arch.backend.api.elasticsearch.aggregate.FieldSortRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllDateHistogramExtendedBoundses
import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramExtendedBoundsRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllDateHistogramIntervals
import laplacian.arch.backend.api.elasticsearch.aggregate.DateHistogramIntervalRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllAggregateGroupRanges
import laplacian.arch.backend.api.elasticsearch.aggregate.AggregateGroupRangeRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllKeyedFilters
import laplacian.arch.backend.api.elasticsearch.aggregate.KeyedFilterRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchClients
import laplacian.arch.backend.api.elasticsearch.ElasticsearchClientRecord
import laplacian.arch.backend.api.elasticsearch.aggregate.AllElasticsearchAggregates
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchIndexes
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchIndexSorts
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexSortRecord
import laplacian.arch.backend.api.elasticsearch.query.AllElasticsearchQueryCollapses
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryCollapseRecord
import laplacian.arch.backend.api.elasticsearch.query.AllElasticsearchQueryPredicates
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQueryPredicateRecord
import laplacian.arch.backend.api.elasticsearch.query.AllElasticsearchQuerySorts
import laplacian.arch.backend.api.elasticsearch.query.ElasticsearchQuerySortRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchQueries
import laplacian.arch.backend.api.elasticsearch.ElasticsearchQueryRecord
import laplacian.arch.backend.api.graphql.AllGraphqlTypes
import laplacian.arch.backend.api.graphql.GraphqlTypeRecord
import laplacian.arch.backend.api.rest.AllArgumentAssignments
import laplacian.arch.backend.api.rest.ArgumentAssignmentRecord
import laplacian.arch.backend.api.rest.AllArgumentAssignmentValues
import laplacian.arch.backend.api.rest.ArgumentAssignmentValueRecord
import laplacian.arch.backend.api.rest.AllRestOperationParameters
import laplacian.arch.backend.api.rest.RestOperationParameterRecord
import laplacian.arch.backend.api.rest.AllRestOperationBodyDefinitions
import laplacian.arch.backend.api.rest.RestOperationBodyDefinitionRecord
import laplacian.arch.backend.api.rest.AllRestOperationBodySchemas
import laplacian.arch.backend.api.rest.RestOperationBodySchemaRecord
import laplacian.arch.backend.api.rest.AllRestOperationDependencies
import laplacian.arch.backend.api.rest.RestOperationDependencyRecord
import laplacian.arch.backend.api.rest.AllRestResourceEntries
import laplacian.arch.backend.api.rest.RestResourceEntryRecord
import laplacian.arch.backend.api.rest.AllRestResources
import laplacian.arch.backend.api.rest.RestResourceRecord
import laplacian.arch.backend.api.AllServices
import laplacian.arch.backend.api.ServiceRecord
import laplacian.arch.backend.api.AllDatasourceEntries
import laplacian.arch.backend.api.DatasourceEntryRecord
import laplacian.arch.backend.api.AllServiceConfigurations
import laplacian.arch.backend.api.ServiceConfigurationRecord
import laplacian.arch.backend.api.AllConfigurationBindings
import laplacian.arch.backend.api.ConfigurationBindingRecord

import laplacian.generate.util.*

@Extension
class BackendApiDomainModelModelEntryResolver: ModelEntryResolver {

    override fun resolves(key: String, model: Map<String, Any?>): Boolean {
        return arrayOf(
            "aggregate_entries",
            "aggregates",
            "api_call_arguments",
            "cache_policies",
            "data_files",
            "datasources",
            "durations",
            "bucket_script_paths",
            "field_sorts",
            "date_histogram_extended_boundses",
            "date_histogram_intervals",
            "aggregate_group_ranges",
            "keyed_filters",
            "elasticsearch_clients",
            "elasticsearch_aggregates",
            "elasticsearch_indexes",
            "elasticsearch_index_sorts",
            "elasticsearch_query_collapses",
            "elasticsearch_query_predicates",
            "elasticsearch_query_sorts",
            "elasticsearch_queries",
            "graphql_types",
            "argument_assignments",
            "argument_assignment_values",
            "rest_operation_parameters",
            "rest_operation_body_definitions",
            "rest_operation_body_schemas",
            "rest_operation_dependencies",
            "rest_resource_entries",
            "rest_resources",
            "services",
            "datasource_entries",
            "service_configurations",
            "configuration_bindings"
        ).any { it == key }
    }

    override fun resolve(key: String, model: Map<String, Any?>, context: ExecutionContext): Any? {
        return when (key) {
            "aggregate_entries" -> AllAggregateEntries(
                model.getList<Record>("aggregate_entries", emptyList())
                     .mergeWithKeys("name", "namespace")
                     .let{ AggregateEntryRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "aggregates" -> AllAggregates(
                model.getList<Record>("aggregates", emptyList())
                     .mergeWithKeys("name", "namespace")
                     .let{ AggregateRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "api_call_arguments" -> AllApiCallArguments(
                model.getList<Record>("api_call_arguments", emptyList())
                     .mergeWithKeys("name")
                     .let{ ApiCallArgumentRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "cache_policies" -> AllCachePolicies(
                model.getList<Record>("cache_policies", emptyList())
                     .mergeWithKeys("name")
                     .let{ CachePolicyRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "data_files" -> AllDataFiles(
                model.getList<Record>("data_files", emptyList())
                     .mergeWithKeys("name")
                     .let{ DataFileRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "datasources" -> AllDatasources(
                model.getList<Record>("datasources", emptyList())
                     .mergeWithKeys("name")
                     .let{ DatasourceRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "durations" -> AllDurations(
                model.getList<Record>("durations", emptyList())
                     .mergeWithKeys()
                     .let{ DurationRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "bucket_script_paths" -> AllBucketScriptPaths(
                model.getList<Record>("bucket_script_paths", emptyList())
                     .mergeWithKeys()
                     .let{ BucketScriptPathRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "field_sorts" -> AllFieldSorts(
                model.getList<Record>("field_sorts", emptyList())
                     .mergeWithKeys("field")
                     .let{ FieldSortRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "date_histogram_extended_boundses" -> AllDateHistogramExtendedBoundses(
                model.getList<Record>("date_histogram_extended_boundses", emptyList())
                     .mergeWithKeys()
                     .let{ DateHistogramExtendedBoundsRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "date_histogram_intervals" -> AllDateHistogramIntervals(
                model.getList<Record>("date_histogram_intervals", emptyList())
                     .mergeWithKeys()
                     .let{ DateHistogramIntervalRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "aggregate_group_ranges" -> AllAggregateGroupRanges(
                model.getList<Record>("aggregate_group_ranges", emptyList())
                     .mergeWithKeys("key")
                     .let{ AggregateGroupRangeRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "keyed_filters" -> AllKeyedFilters(
                model.getList<Record>("keyed_filters", emptyList())
                     .mergeWithKeys("key")
                     .let{ KeyedFilterRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_clients" -> AllElasticsearchClients(
                model.getList<Record>("elasticsearch_clients", emptyList())
                     .mergeWithKeys("name")
                     .let{ ElasticsearchClientRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_aggregates" -> AllElasticsearchAggregates(
                model.getList<Record>("elasticsearch_aggregates", emptyList())
                     .mergeWithKeys("name")
                     .let{ ElasticsearchAggregateRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_indexes" -> AllElasticsearchIndexes(
                model.getList<Record>("elasticsearch_indexes", emptyList())
                     .mergeWithKeys("name")
                     .let{ ElasticsearchIndexRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_index_sorts" -> AllElasticsearchIndexSorts(
                model.getList<Record>("elasticsearch_index_sorts", emptyList())
                     .mergeWithKeys("field")
                     .let{ ElasticsearchIndexSortRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_query_collapses" -> AllElasticsearchQueryCollapses(
                model.getList<Record>("elasticsearch_query_collapses", emptyList())
                     .mergeWithKeys("field")
                     .let{ ElasticsearchQueryCollapseRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_query_predicates" -> AllElasticsearchQueryPredicates(
                model.getList<Record>("elasticsearch_query_predicates", emptyList())
                     .mergeWithKeys("type")
                     .let{ ElasticsearchQueryPredicateRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_query_sorts" -> AllElasticsearchQuerySorts(
                model.getList<Record>("elasticsearch_query_sorts", emptyList())
                     .mergeWithKeys("type")
                     .let{ ElasticsearchQuerySortRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elasticsearch_queries" -> AllElasticsearchQueries(
                model.getList<Record>("elasticsearch_queries", emptyList())
                     .mergeWithKeys("name", "index_name")
                     .let{ ElasticsearchQueryRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "graphql_types" -> AllGraphqlTypes(
                model.getList<Record>("graphql_types", emptyList())
                     .mergeWithKeys("name", "group")
                     .let{ GraphqlTypeRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "argument_assignments" -> AllArgumentAssignments(
                model.getList<Record>("argument_assignments", emptyList())
                     .mergeWithKeys("key")
                     .let{ ArgumentAssignmentRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "argument_assignment_values" -> AllArgumentAssignmentValues(
                model.getList<Record>("argument_assignment_values", emptyList())
                     .mergeWithKeys()
                     .let{ ArgumentAssignmentValueRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_operation_parameters" -> AllRestOperationParameters(
                model.getList<Record>("rest_operation_parameters", emptyList())
                     .mergeWithKeys("name")
                     .let{ RestOperationParameterRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_operation_body_definitions" -> AllRestOperationBodyDefinitions(
                model.getList<Record>("rest_operation_body_definitions", emptyList())
                     .mergeWithKeys()
                     .let{ RestOperationBodyDefinitionRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_operation_body_schemas" -> AllRestOperationBodySchemas(
                model.getList<Record>("rest_operation_body_schemas", emptyList())
                     .mergeWithKeys("name", "namespace")
                     .let{ RestOperationBodySchemaRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_operation_dependencies" -> AllRestOperationDependencies(
                model.getList<Record>("rest_operation_dependencies", emptyList())
                     .mergeWithKeys()
                     .let{ RestOperationDependencyRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_resource_entries" -> AllRestResourceEntries(
                model.getList<Record>("rest_resource_entries", emptyList())
                     .mergeWithKeys("name", "namespace")
                     .let{ RestResourceEntryRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_resources" -> AllRestResources(
                model.getList<Record>("rest_resources", emptyList())
                     .mergeWithKeys("name", "namespace")
                     .let{ RestResourceRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "services" -> AllServices(
                model.getList<Record>("services", emptyList())
                     .mergeWithKeys("name")
                     .let{ ServiceRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "datasource_entries" -> AllDatasourceEntries(
                model.getList<Record>("datasource_entries", emptyList())
                     .mergeWithKeys("name")
                     .let{ DatasourceEntryRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "service_configurations" -> AllServiceConfigurations(
                model.getList<Record>("service_configurations", emptyList())
                     .mergeWithKeys("name", "category")
                     .let{ ServiceConfigurationRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "configuration_bindings" -> AllConfigurationBindings(
                model.getList<Record>("configuration_bindings", emptyList())
                     .mergeWithKeys("name", "category")
                     .let{ ConfigurationBindingRecord.from(it, context.currentModel) },
                context.currentModel
            )
            else -> throw IllegalArgumentException("Unknown key: $key")
        }
    }
}
