package `in`.aika.riotdataexplorer.api.model.lol.event

import `in`.aika.riotdataexplorer.api.model.lol.PositionDto

data class TurretPlateDestroyed(
    override val timestamp: Long,
    override val type: String,

    val position: PositionDto,
    val laneType: String, // TODO: enum? MID_LANE, ... ?

    val teamId: Int,
    val killerId: Int,
) : EventsTimeLineDto()
