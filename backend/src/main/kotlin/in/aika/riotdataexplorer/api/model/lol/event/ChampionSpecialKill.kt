package `in`.aika.riotdataexplorer.api.model.lol.event

import `in`.aika.riotdataexplorer.api.model.lol.PositionDto

data class ChampionSpecialKill(
    override val timestamp: Long,
    override val type: String,

    val killType: String, // TODO: enum? KILL_FIRST_BLOOD, ... ?
    val killerId: Int,
    val position: PositionDto,

    // killType: KILL_MULTI
    val multiKillLength: Int,
) : EventsTimeLineDto()
