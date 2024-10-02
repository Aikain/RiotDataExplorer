package `in`.aika.riotdataexplorer.api.model.data.riot

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

data class Queue(
    val queueId: Int,

    @JsonView(Views.CurrentGameGet::class)
    val map: String,

    @JsonView(Views.CurrentGameGet::class)
    val description: String?,

    val notes: String?,
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = Queue(-1, "Unknown", null, null)
    }
}
