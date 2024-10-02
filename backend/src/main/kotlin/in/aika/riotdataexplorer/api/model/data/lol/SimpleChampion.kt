package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class SimpleChampion(
    val id: String,
    val version: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: ChampionInfo,
    val image: Image,
    val tags: List<String>,
    val partype: String,
    val stats: ChampionStats
) : LogIgnoredProperties(), DataFiller<SimpleChampion> {

    override fun getFilledData(version: String): SimpleChampion = this.apply {
        image.updateUrls(version)
    }
}
