package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftAugment(
    val id: String,
    val name: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftAugment> {

    override fun getFilledData(version: String): TftAugment = this.apply {
        image.updateUrls(version)
    }
}
