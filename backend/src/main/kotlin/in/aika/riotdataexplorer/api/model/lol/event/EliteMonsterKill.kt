package `in`.aika.riotdataexplorer.api.model.lol.event

import `in`.aika.riotdataexplorer.api.model.lol.PositionDto

data class EliteMonsterKill(
    override val timestamp: Long,
    override val type: String,

    val monsterType: String, // TODO: enum? HORDE, ... ?
    val monsterSubType: String?, // TODO: enum? CHEMTECH_DRAGON, FIRE_DRAGON, ... ?
    val position: PositionDto,

    val killerTeamId: Int,
    val killerId: Int,
    val assistingParticipantIds: List<Int> = listOf(),

    val bounty: Int,
) : EventsTimeLineDto()
