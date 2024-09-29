package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class TournamentPhaseDto(
    val id: Int,
    val registrationTime: Long, // TODO: OffsetDateTime ?
    val startTime: Long, // TODO: OffsetDateTime ?
    val cancelled: Boolean,
) : LogIgnoredProperties()
