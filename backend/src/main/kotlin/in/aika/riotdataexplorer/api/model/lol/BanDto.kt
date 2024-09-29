package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class BanDto(
    val championId: Int,
    val pickTurn: Int,
) : LogIgnoredProperties()
