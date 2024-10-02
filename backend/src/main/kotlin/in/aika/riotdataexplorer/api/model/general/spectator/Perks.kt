package `in`.aika.riotdataexplorer.api.model.general.spectator

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

@JsonView(Views.CurrentGameGet::class)
data class Perks(
    val perkIds: List<Long>,
    val perkStyle: Long,
    val perkSubStyle: Long,
) : LogIgnoredProperties()
