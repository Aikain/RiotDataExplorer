package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftArena(
    val id: String,
    val name: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftArena> {

    override fun getFilledData(version: String): TftArena = this.apply {
        image.updateUrls(version)
    }
}
