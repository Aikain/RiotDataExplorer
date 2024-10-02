package `in`.aika.riotdataexplorer.api.model.data.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Season(
    val id: Int,
    val season: String,
) : LogIgnoredProperties()
