package laplacian.arch.deployment.component.elasticsearch
import com.github.jknack.handlebars.Context
import laplacian.arch.deployment.component.elasticsearch.ConfigurationFile


import laplacian.arch.deployment.component.container.ContainerImageRecord

import laplacian.generate.util.*
/**
 * An entity describing a elasticsearch_container_image.
 */
data class ElasticsearchContainerImageRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): ContainerImageRecord(__record, _context), ElasticsearchContainerImage {

    /**
     * The base_name of this elasticsearch_container_image.
     */
    override val baseName: String
        get() = getOrThrow("baseName") {
            "elasticsearch"
        }
    /**
     * The plugins of this elasticsearch_container_image.
     */
    override val plugins: List<String>
        get() = getOrThrow("plugins") {
            emptyList<String>()
        }
    /**
     * The configuration_file_dir_path of this elasticsearch_container_image.
     */
    override val configurationFileDirPath: String
        get() = getOrThrow("configurationFileDirPath") {
            "/usr/share/elasticsearch/config"
        }
    /**
     * Defines this elasticsearch_container_image is uses_custom_image or not.
     */
    override val usesCustomImage: Boolean
        get() = plugins.isNotEmpty() || configurationFiles.isNotEmpty()
    /**
     * The configuration_files of this elasticsearch_container_image.
     */
    override val configurationFiles: List<ConfigurationFile> by lazy {
        ConfigurationFileRecord.from(_record.getList("configuration_files", emptyList()), _context)
    }
    /**
     * Returns wether this instance is a elasticsearch_container_image or not.
     */
    override val isaElasticsearchContainerImage: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            ElasticsearchContainerImageRecord(record, _context)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ElasticsearchContainerImageRecord) return false
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        return result
    }

    override fun toString(): String {
        return "ElasticsearchContainerImageRecord(" +
            "name=$name" +
        ")"
    }
}
