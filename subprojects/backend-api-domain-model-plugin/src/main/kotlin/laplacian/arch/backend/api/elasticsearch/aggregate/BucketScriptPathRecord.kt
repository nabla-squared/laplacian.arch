package laplacian.arch.backend.api.elasticsearch.aggregate
import com.github.jknack.handlebars.Context



import laplacian.generate.util.*
/**
 * An entity describing a bucket_script_path.
 */
data class BucketScriptPathRecord (
    private val __record: Record,
    private val _context: Context,
    private val _record: Record = __record.normalizeCamelcase()
): BucketScriptPath, Record by _record {

    /**
     * The name of this bucket_script_path.
     */
    override val name: String
        get() = getOrThrow("name")
    /**
     * The path of this bucket_script_path.
     */
    override val path: String
        get() = getOrThrow("path")
    /**
     * Returns wether this instance is a bucket_script_path or not.
     */
    override val isaBucketScriptPath: Boolean = true

    companion object {
        /**
         * Creates record list from list of map.
         */
        fun from(_context: Context): AllBucketScriptPaths {
            return _context.get("bucket_script_paths") as AllBucketScriptPaths
        }
        fun from(records: RecordList, _context: Context) = records.map { from(it, _context) }

        fun from(record: Record, _context: Context) =
            BucketScriptPathRecord(record, _context)
    }
}
