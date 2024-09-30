package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameMode(
    val gameMode: String,
    val description: String,
) : LogIgnoredProperties()
