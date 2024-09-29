package `in`.aika.riotdataexplorer.api.model.general.status

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.time.OffsetDateTime

data class UpdateDto(
    val id: Int,
    val author: String,
    val publish: Boolean,

    @JsonAlias("publish_locations")
    val publishLocations: List<PublishLocation>,
    val translations: List<ContentDto>,

    @JsonAlias("created_at")
    val createdAt: OffsetDateTime,

    @JsonAlias("updated_at")
    val updatedAt: OffsetDateTime,
) : LogIgnoredProperties() {
    enum class PublishLocation {
        RIOTCLIENT,
        RIOTSTATUS,
        GAME,
    }
}
