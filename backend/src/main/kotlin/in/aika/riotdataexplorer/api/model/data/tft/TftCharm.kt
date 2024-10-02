package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftCharm(
    val id: String,
    val name: String,
    val cost: Int,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftCharm> {

    override fun getFilledData(version: String): TftCharm = this.apply {
        image.updateUrls(version)
    }
}
