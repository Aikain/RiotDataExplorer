package `in`.aika.riotdataexplorer.api.model.data.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameMap(
    val mapId: Int,
    val mapName: String,
    val notes: String,
) : LogIgnoredProperties() {
    lateinit var minimapUrl: String

    companion object {
        val UNKNOWN = GameMap(-1, "Unknown", "Unknown").apply { minimapUrl = "" }
    }
}
