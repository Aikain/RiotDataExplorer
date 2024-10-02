package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftChampion(
    val id: String,
    val name: String,
    val tier: Int,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftChampion> {

    override fun getFilledData(version: String): TftChampion = this.apply {
        image.updateUrls(version)
    }
}
