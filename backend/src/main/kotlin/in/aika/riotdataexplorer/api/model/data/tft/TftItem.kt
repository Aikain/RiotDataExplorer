package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftItem(
    val id: String,
    val name: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftItem> {

    override fun getFilledData(version: String): TftItem = this.apply {
        image.updateUrls(version)
    }
}
