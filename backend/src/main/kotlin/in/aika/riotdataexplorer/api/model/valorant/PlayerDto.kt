package `in`.aika.riotdataexplorer.api.model.valorant

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PlayerDto(
    val puuid: String,
    val gameName: String,
    val tagLine: String,
    val leaderboardRank: Long,
    val rankedRating: Long,
    val numberOfWins: Long,
) : LogIgnoredProperties()
