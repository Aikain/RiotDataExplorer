package `in`.aika.riotdataexplorer.api.model.lol.event

import `in`.aika.riotdataexplorer.api.model.lol.DamageInfo
import `in`.aika.riotdataexplorer.api.model.lol.PositionDto

data class ChampionKill(
    override val timestamp: Long,
    override val type: String,

    val killerId: Int,
    val assistingParticipantIds: List<Int> = listOf(),
    val victimId: Int,
    val position: PositionDto?,

    val victimDamageReceived: List<DamageInfo> = listOf(),
    val victimDamageDealt: List<DamageInfo> = listOf(),

    val bounty: Int,
    val shutdownBounty: Int,
    val killStreakLength: Int,
) : EventsTimeLineDto()
