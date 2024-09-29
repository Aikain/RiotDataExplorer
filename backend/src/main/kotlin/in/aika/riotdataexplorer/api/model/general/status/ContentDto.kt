package `in`.aika.riotdataexplorer.api.model.general.status

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ContentDto(
    val locale: String,
    val content: String,
) : LogIgnoredProperties()
