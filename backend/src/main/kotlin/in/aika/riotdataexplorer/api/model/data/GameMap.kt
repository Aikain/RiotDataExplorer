package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameMap(
    val mapId: Int,
    val mapName: String,
    val notes: String,
) : LogIgnoredProperties()
