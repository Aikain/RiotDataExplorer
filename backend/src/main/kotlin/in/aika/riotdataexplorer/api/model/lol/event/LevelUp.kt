package `in`.aika.riotdataexplorer.api.model.lol.event

data class LevelUp(
    override val timestamp: Long,
    override val type: String,

    val participantId: Int,
    val level: Int,
) : EventsTimeLineDto()
