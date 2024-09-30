package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Queue(
    val queueId: Int,
    val map: String,
    val description: String?,
    val notes: String?,
) : LogIgnoredProperties()
