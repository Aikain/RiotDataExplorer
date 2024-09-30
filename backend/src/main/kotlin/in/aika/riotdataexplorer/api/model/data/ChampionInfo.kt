package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionInfo(
    val attack: Int,
    val defense: Int,
    val magic: Int,
    val difficulty: Int,
) : LogIgnoredProperties()
