package `in`.aika.riotdataexplorer.api.model.lol.event

import `in`.aika.riotdataexplorer.api.model.lol.PositionDto

data class BuildingKill(
    override val timestamp: Long,
    override val type: String,

    val buildingType: String, // TODO: enum? TOWER_BUILDING, ... ?
    val towerType: String?, // TODO: enum? OUTER_TURRET, ... ?
    val position: PositionDto,
    val laneType: String, // TODO: enum? MID_LANE, ... ?

    val teamId: Int,
    val killerId: Int,
    val assistingParticipantIds: List<Int> = listOf(),
    val bounty: Int,
) : EventsTimeLineDto()
