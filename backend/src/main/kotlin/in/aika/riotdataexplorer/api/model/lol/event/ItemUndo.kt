package `in`.aika.riotdataexplorer.api.model.lol.event

data class ItemUndo(
    override val timestamp: Long,
    override val type: String,

    val participantId: Int,
    val beforeId: Int,
    val afterId: Int,
    val goldGain: Int,
) : EventsTimeLineDto()
