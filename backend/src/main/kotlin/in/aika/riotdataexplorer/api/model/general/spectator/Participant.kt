package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Participant(
    val puuid: String, // encrypted
    val summonerId: String, // encrypted
    val riotId: String,
    val profileIconId: Long,
    val bot: Boolean,

    val teamId: Long,
    val championId: Long,

    val spell1Id: Long,
    val spell2Id: Long,
) : LogIgnoredProperties()
