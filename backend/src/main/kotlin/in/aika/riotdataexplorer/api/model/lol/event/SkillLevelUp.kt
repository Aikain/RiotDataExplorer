package `in`.aika.riotdataexplorer.api.model.lol.event

data class SkillLevelUp(
    override val timestamp: Long,
    override val type: String,

    val participantId: Int,
    val levelUpType: String, // TODO: enum? NORMAL, ... ?
    val skillSlot: Int,
) : EventsTimeLineDto()
