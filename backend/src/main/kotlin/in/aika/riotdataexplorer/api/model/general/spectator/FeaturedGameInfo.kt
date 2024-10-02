package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class FeaturedGameInfo(
    val gameId: Long,
    val platformId: String,
    val gameMode: String,
    val gameType: String,
    val gameQueueConfigId: Int,
    val mapId: Int,
    val participants: List<Participant>,
    val bannedChampions: List<BannedChampion>,
    val gameLength: Long, // seconds
    val observers: Observer,
) : LogIgnoredProperties()
