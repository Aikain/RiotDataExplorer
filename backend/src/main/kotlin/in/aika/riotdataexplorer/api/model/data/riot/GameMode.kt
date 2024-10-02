package `in`.aika.riotdataexplorer.api.model.data.riot

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

@JsonView(Views.CurrentGameGet::class)
data class GameMode(
    val gameMode: String,
    val description: String,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = GameMode("UNKNOWN", "")
    }
}
