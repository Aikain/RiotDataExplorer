package `in`.aika.riotdataexplorer.api.model.data.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameMode(
    val gameMode: String,
    val description: String,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = GameMode("UNKNOWN", "")
    }
}
