package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftTactician(
    val id: String,
    val tier: String,
    val name: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftTactician> {

    override fun getFilledData(version: String): TftTactician = this.apply {
        image.updateUrls(version)
    }
}
