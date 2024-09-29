package `in`.aika.riotdataexplorer.api.model.lol.event

data class WardKill(
    override val timestamp: Long,
    override val type: String,

    val killerId: Int,
    val wardType: String, // TODO: enum? UNDEFINED, ... ?
) : EventsTimeLineDto()
