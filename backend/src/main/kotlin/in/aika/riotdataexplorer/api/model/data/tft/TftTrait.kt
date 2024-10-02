package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftTrait(
    val id: String,
    val name: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftTrait> {

    override fun getFilledData(version: String): TftTrait = this.apply {
        image.updateUrls(version)
    }
}
