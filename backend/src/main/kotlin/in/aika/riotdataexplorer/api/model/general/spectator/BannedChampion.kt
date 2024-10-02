package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class BannedChampion(
    val pickTurn: Int,
    val championId: Int,
    val teamId: Long,
) : LogIgnoredProperties()
