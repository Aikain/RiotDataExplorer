package `in`.aika.riotdataexplorer.api.model.valorant

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class LeaderboardDto(
    val shard: String,
    val actId: String,
    val totalPlayers: Long,
    val players: List<PlayerDto>,
) : LogIgnoredProperties()
