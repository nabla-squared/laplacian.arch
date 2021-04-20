package laplacian.arch.backend.api.plugin
import org.pf4j.Extension
import laplacian.generate.ModelEntryResolver
import laplacian.generate.ExecutionContext
import laplacian.arch.backend.api.AllApiCallArguments
import laplacian.arch.backend.api.ApiCallArgumentRecord
import laplacian.arch.backend.api.cache.AllCachePolicies
import laplacian.arch.backend.api.cache.CachePolicyRecord
import laplacian.arch.backend.api.data_file.AllDataFiles
import laplacian.arch.backend.api.data_file.DataFileRecord
import laplacian.arch.backend.api.datasource.AllDatasources
import laplacian.arch.backend.api.datasource.DatasourceRecord
import laplacian.arch.backend.api.datasource.AllDatasourceEntries
import laplacian.arch.backend.api.datasource.DatasourceEntryRecord
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
import laplacian.arch.backend.api.elasticsearch.aggregate.AllElasticsearchAggregates
import laplacian.arch.backend.api.elasticsearch.aggregate.ElasticsearchAggregateRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchIndexes
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexRecord
import laplacian.arch.backend.api.elasticsearch.AllElasticsearchIndexSorts
import laplacian.arch.backend.api.elasticsearch.ElasticsearchIndexSortRecord
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
import laplacian.arch.backend.api.rest.AllRestOperationResponses
import laplacian.arch.backend.api.rest.RestOperationResponseRecord
import laplacian.arch.backend.api.rest.AllRestRequestParameters
import laplacian.arch.backend.api.rest.RestRequestParameterRecord
import laplacian.arch.backend.api.rest.AllRestResources
import laplacian.arch.backend.api.rest.RestResourceRecord
import laplacian.arch.backend.api.AllServices
import laplacian.arch.backend.api.ServiceRecord
import laplacian.arch.backend.api.AllElasticSearchClients
import laplacian.arch.backend.api.ElasticSearchClientRecord
import laplacian.arch.backend.api.AllServiceConfigurations
import laplacian.arch.backend.api.ServiceConfigurationRecord
import laplacian.arch.backend.api.AllConfigurationBindings
import laplacian.arch.backend.api.ConfigurationBindingRecord

import laplacian.generate.util.*

@Extension
class BackendApiDomainModelModelEntryResolver: ModelEntryResolver {

    override fun resolves(key: String, model: Map<String, Any?>): Boolean {
        return arrayOf(
            "api_call_arguments",
            "cache_policies",
            "data_files",
            "datasources",
            "datasource_entries",
            "durations",
            "bucket_script_paths",
            "field_sorts",
            "date_histogram_extended_boundses",
            "date_histogram_intervals",
            "aggregate_group_ranges",
            "keyed_filters",
            "elasticsearch_aggregates",
            "elasticsearch_indexes",
            "elasticsearch_index_sorts",
            "elasticsearch_query_predicates",
            "elasticsearch_query_sorts",
            "elasticsearch_queries",
            "graphql_types",
            "argument_assignments",
            "argument_assignment_values",
            "rest_operation_responses",
            "rest_request_parameters",
            "rest_resources",
            "services",
            "elastic_search_clients",
            "service_configurations",
            "configuration_bindings"
        ).any { it == key }
    }

    override fun resolve(key: String, model: Map<String, Any?>, context: ExecutionContext): Any? {
        return when (key) {
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
            "datasource_entries" -> AllDatasourceEntries(
                model.getList<Record>("datasource_entries", emptyList())
                     .mergeWithKeys()
                     .let{ DatasourceEntryRecord.from(it, context.currentModel) },
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
            "rest_operation_responses" -> AllRestOperationResponses(
                model.getList<Record>("rest_operation_responses", emptyList())
                     .mergeWithKeys()
                     .let{ RestOperationResponseRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_request_parameters" -> AllRestRequestParameters(
                model.getList<Record>("rest_request_parameters", emptyList())
                     .mergeWithKeys("name")
                     .let{ RestRequestParameterRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "rest_resources" -> AllRestResources(
                model.getList<Record>("rest_resources", emptyList())
                     .mergeWithKeys("name")
                     .let{ RestResourceRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "services" -> AllServices(
                model.getList<Record>("services", emptyList())
                     .mergeWithKeys("name")
                     .let{ ServiceRecord.from(it, context.currentModel) },
                context.currentModel
            )
            "elastic_search_clients" -> AllElasticSearchClients(
                model.getList<Record>("elastic_search_clients", emptyList())
                     .mergeWithKeys()
                     .let{ ElasticSearchClientRecord.from(it, context.currentModel) },
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
