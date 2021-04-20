package laplacian.arch.backend.api.elasticsearch.aggregate


import laplacian.util.*

/**
 * An entity describing a field_sort.
 */
interface FieldSort {
    /**
     * The field of this field_sort.
     */
    val field: String
    /**
     * The order of this field_sort.
     */
    val order: String?
    /**
     * Defines this field_sort is variable_order or not.
     */
    val variableOrder: Boolean
    /**
     * Returns wether this instance is a field_sort or not.
     */
    val isaFieldSort: Boolean
}
