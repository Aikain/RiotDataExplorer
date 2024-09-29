package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ParticipantTimeLineDto(
    val participantId: Int,
    val puuid: String,
) : LogIgnoredProperties()
