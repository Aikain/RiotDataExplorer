package `in`.aika.riotdataexplorer.api.model.data.lol

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

data class Rune(
    val id: Long,
    val key: String,
    val icon: String,

    @JsonView(Views.CurrentGameGet::class)
    val name: String,

    val shortDesc: String,
    val longDesc: String,
) : LogIgnoredProperties() {

    @JsonView(Views.CurrentGameGet::class)
    val iconUrl = "https://ddragon.leagueoflegends.com/cdn/img/$icon"
}
