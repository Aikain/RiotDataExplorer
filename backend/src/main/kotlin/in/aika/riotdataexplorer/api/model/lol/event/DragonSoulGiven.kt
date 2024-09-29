package `in`.aika.riotdataexplorer.api.model.lol.event

data class DragonSoulGiven(
    override val timestamp: Long,
    override val type: String,

    val teamId: Int,
    val name: String, // TODO: enum? Hextech, ... ?
) : EventsTimeLineDto()
