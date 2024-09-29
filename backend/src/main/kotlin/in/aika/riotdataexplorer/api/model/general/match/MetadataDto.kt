package `in`.aika.riotdataexplorer.api.model.general.match

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MetadataDto(
    @JsonAlias("data_version")
    val dataVersion: String,

    @JsonAlias("match_id")
    val matchId: String,
    val participants: List<String>, // puuids
) : LogIgnoredProperties()
