package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class TimelineDto(
    val metadata: MetadataTimeLineDto,
    val info: InfoTimeLineDto,
) : LogIgnoredProperties()
