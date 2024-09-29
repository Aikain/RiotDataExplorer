package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionInfo(
    val maxNewPlayerLevel: Int,
    val freeChampionIdsForNewPlayers: List<Int>,
    val freeChampionIds: List<Int>,
) : LogIgnoredProperties()
