package `in`.aika.riotdataexplorer.api.model.data.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class TftQueue(
    val id: String,
    val name: String,
    val queueType: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftQueue> {

    override fun getFilledData(version: String): TftQueue = this.apply {
        image.updateUrls(version)
    }
}
