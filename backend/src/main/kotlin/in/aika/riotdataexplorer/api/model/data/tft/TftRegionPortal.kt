package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftRegionPortal(
    val name: String,
    val shortDescription: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftRegionPortal> {

    override fun getFilledData(version: String): TftRegionPortal = this.apply {
        image.updateUrls(version)
    }
}
