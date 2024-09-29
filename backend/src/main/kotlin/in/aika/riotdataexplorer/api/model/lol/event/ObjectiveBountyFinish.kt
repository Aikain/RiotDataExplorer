package `in`.aika.riotdataexplorer.api.model.lol.event

data class ObjectiveBountyFinish(
    override val timestamp: Long,
    override val type: String,

    val teamId: Int,
) : EventsTimeLineDto()
