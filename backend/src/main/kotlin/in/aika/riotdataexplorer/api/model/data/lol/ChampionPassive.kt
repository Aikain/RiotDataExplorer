package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image

data class ChampionPassive(
    val name: String,
    val description: String,
    val image: Image,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = ChampionPassive("UNKNOWN", "", Image.UNKNOWN.apply { updateUrls("") })
    }
}
