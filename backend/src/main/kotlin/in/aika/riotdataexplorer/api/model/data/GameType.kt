package `in`.aika.riotdataexplorer.api.model.data

import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameType(
    @JsonProperty("gametype")
    val gameType: String,
    val description: String,
) : LogIgnoredProperties()
