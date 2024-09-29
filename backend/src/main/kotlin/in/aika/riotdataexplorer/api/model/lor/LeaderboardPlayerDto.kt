package `in`.aika.riotdataexplorer.api.model.lor

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class LeaderboardPlayerDto(
    val name: String,
    val rank: Int,
    val lp: Int, // League points
) : LogIgnoredProperties()
