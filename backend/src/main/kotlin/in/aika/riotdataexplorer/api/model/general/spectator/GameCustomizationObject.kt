package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class GameCustomizationObject(
    val category: String,
    val content: String,
) : LogIgnoredProperties()
