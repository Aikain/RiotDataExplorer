package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MetadataTimeLineDto(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>, // puuids
) : LogIgnoredProperties()
