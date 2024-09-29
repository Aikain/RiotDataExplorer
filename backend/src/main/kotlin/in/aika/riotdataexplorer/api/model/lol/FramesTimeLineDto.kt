package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.lol.event.EventsTimeLineDto

data class FramesTimeLineDto(
    val events: List<EventsTimeLineDto>,
    val participantFrames: Map<String, ParticipantFrameDto>,
    val timestamp: Int,
) : LogIgnoredProperties()
