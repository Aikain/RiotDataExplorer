package `in`.aika.riotdataexplorer.api.model.data.riot

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameType(
    @JsonAlias("gametype")
    val gameType: String,
    val description: String,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = GameType("UNKNOWN", "")
    }
}
