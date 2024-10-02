package `in`.aika.riotdataexplorer.api.model.data.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Queue(
    val queueId: Int,
    val map: String,
    val description: String?,
    val notes: String?,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = Queue(-1, "Unknown", null, null)
    }
}
