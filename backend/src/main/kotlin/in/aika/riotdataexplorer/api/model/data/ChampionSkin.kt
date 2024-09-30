package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionSkin(
    val id: String,
    val num: Int,
    val name: String,
    val chromas: Boolean,
) : LogIgnoredProperties()
