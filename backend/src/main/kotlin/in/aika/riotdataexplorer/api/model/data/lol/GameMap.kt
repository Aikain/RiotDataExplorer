package `in`.aika.riotdataexplorer.api.model.data.lol

import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller

data class GameMap(
    @JsonProperty("MapName")
    val mapName: String,
    @JsonProperty("MapId")
    val mapId: String,
    val image: Image,
) : LogIgnoredProperties(), DataFiller<GameMap> {

    override fun getFilledData(version: String): GameMap = this.apply {
        image.updateUrls(version)
    }
}
