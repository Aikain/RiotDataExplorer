package `in`.aika.riotdataexplorer.api.model.lol.event

data class ItemDestroyed(
    override val timestamp: Long,
    override val type: String,

    val participantId: Int,
    val itemId: Int,
) : EventsTimeLineDto()
