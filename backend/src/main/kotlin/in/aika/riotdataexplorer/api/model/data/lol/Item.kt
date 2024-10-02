package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class Item(
    val name: String,
    val description: String,
    val colloq: String,
    val plaintext: String,
    val info: List<String>,
    val image: Image,
    val gold: ItemGold,
    val tags: List<String>,
    val maps: Map<String, Boolean>,
    val stats: Map<String, Int>,
) : LogIgnoredProperties(), DataFiller<Item> {

    override fun getFilledData(version: String): Item = this.apply {
        image.updateUrls(version)
    }
}
