package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class InfoTimeLineDto(
    val gameId: Long,
    val participants: List<ParticipantTimeLineDto>,
    val frameInterval: Long,
    val frames: List<FramesTimeLineDto>,
    val endOfGameResult: String?,
) : LogIgnoredProperties()
