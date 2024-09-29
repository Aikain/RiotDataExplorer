package `in`.aika.riotdataexplorer.api.model.lol.event

data class ChampionTransform(
    override val timestamp: Long,
    override val type: String,

    val participantId: Int,
    val transformType: String?, // TODO: enum? ASSASSIN, ...
) : EventsTimeLineDto()
