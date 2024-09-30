package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionDataWrapper<Champion>(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, Champion>
) : LogIgnoredProperties()
