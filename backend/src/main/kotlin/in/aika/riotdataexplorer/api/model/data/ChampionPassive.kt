package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionPassive(
    val name: String,
    val description: String,
    val image: Image,
) : LogIgnoredProperties()
