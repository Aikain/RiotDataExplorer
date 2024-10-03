package `in`.aika.riotdataexplorer.api.model.data.tft

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.riot.Queue
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller
import `in`.aika.riotdataexplorer.domain.Views

data class TftQueue(
    val id: String,

    @JsonView(Views.CurrentGameGet::class)
    val name: String,

    @JsonView(Views.CurrentGameGet::class)
    val queueType: String,

    @JsonView(Views.CurrentGameGet::class)
    val image: Image,
) : LogIgnoredProperties(), DataFiller<TftQueue> {

    companion object {
        val UNKNOWN = TftQueue("0", "Unknown", "UNKNOWN", Image.UNKNOWN)
    }

    override fun getFilledData(version: String): TftQueue =
        copy(
            id = id,
            name = name,
            queueType = queueType,
            image = image.copy(
                full = image.full,
                sprite = image.sprite.replace("-type", ""),
                group = image.group.replace("-type", ""),
                x = image.x,
                y = image.y,
                w = image.w,
                h = image.h
            ).apply {
                updateUrls(version)
            },
        )
}
