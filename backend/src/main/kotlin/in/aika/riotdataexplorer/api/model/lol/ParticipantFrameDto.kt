package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ParticipantFrameDto(
    val championStats: ChampionStatsDto,
    val currentGold: Int,
    val damageStats: DamageStatsDto,
    val goldPerSecond: Int,
    val jungleMinionsKilled: Int,
    val level: Int,
    val minionsKilled: Int,
    val participantId: Int,
    val position: PositionDto,
    val timeEnemySpentControlled: Int,
    val totalGold: Int,
    val xp: Int,
) : LogIgnoredProperties()
