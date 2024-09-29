package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.util.*

data class CompanionDto(
    @JsonAlias("content_ID")
    val contentId: UUID,

    @JsonAlias("item_ID")
    val itemId: Int,

    @JsonAlias("skin_ID")
    val skinId: Int,
    val species: String,
) : LogIgnoredProperties()
