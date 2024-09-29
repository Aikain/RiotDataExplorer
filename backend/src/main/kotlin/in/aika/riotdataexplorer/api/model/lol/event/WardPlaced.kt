package `in`.aika.riotdataexplorer.api.model.lol.event

data class WardPlaced(
    override val timestamp: Long,
    override val type: String,

    val creatorId: Int,
    val wardType: String, // TODO: enum? UNDEFINED, ... ?
) : EventsTimeLineDto()
