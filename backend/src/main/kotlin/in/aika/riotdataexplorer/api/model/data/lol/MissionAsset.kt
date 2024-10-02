package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class MissionAsset(
    val id: Int,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<MissionAsset> {

    override fun getFilledData(version: String): MissionAsset = this.apply {
        image.updateUrls(version)
    }
}
