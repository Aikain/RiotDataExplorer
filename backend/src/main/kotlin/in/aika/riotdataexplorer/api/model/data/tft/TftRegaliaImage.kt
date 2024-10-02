package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftRegaliaImage(
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftRegaliaImage> {

    override fun getFilledData(version: String): TftRegaliaImage = this.apply {
        image.updateUrls(version)
    }
}
