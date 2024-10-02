package `in`.aika.riotdataexplorer.api.model.data.riot

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

data class GameMap(
    val mapId: Int,

    @JsonView(Views.CurrentGameGet::class)
    val mapName: String,

    @JsonView(Views.CurrentGameGet::class)
    val notes: String,
) : LogIgnoredProperties() {
    @JsonView(Views.CurrentGameGet::class)
    lateinit var minimapUrl: String

    companion object {
        val UNKNOWN = GameMap(-1, "Unknown", "Unknown").apply { minimapUrl = "" }
    }
}
