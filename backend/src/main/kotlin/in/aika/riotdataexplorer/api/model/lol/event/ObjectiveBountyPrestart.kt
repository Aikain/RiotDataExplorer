package `in`.aika.riotdataexplorer.api.model.lol.event

data class ObjectiveBountyPrestart(
    override val timestamp: Long,
    override val type: String,

    val teamId: Int,
    val actualStartTime: Int,
) : EventsTimeLineDto()
