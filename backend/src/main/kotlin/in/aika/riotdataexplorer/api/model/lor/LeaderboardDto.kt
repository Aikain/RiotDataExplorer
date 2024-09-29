package `in`.aika.riotdataexplorer.api.model.lor

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class LeaderboardDto(
    val players: List<LeaderboardPlayerDto>,
) : LogIgnoredProperties()
