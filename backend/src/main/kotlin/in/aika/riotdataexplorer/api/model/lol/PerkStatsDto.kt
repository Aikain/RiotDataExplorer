package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PerkStatsDto(
    val defense: Int,
    val flex: Int,
    val offense: Int,
) : LogIgnoredProperties()
