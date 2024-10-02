package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionSkin(
    val id: String,
    val num: Int,
    val name: String,
    val chromas: Boolean,
) : LogIgnoredProperties() {
    lateinit var splashImgUrl: String
    lateinit var loadingImgUrl: String
}
