package `in`.aika.riotdataexplorer.api.model.lol.event

data class Unknown(
    override val timestamp: Long,
    override val type: String,
) : EventsTimeLineDto()
