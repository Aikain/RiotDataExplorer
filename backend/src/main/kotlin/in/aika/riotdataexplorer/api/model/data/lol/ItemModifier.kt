package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class ItemModifier(
    val image: Image,
) : LogIgnoredProperties(), DataFiller<ItemModifier> {

    override fun getFilledData(version: String): ItemModifier = this.apply {
        image.updateUrls(version)
    }
}
