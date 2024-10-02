package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.data.lol.Rune
import `in`.aika.riotdataexplorer.api.model.data.lol.RuneTree
import `in`.aika.riotdataexplorer.domain.Views

@JsonView(Views.CurrentGameGet::class)
data class Perks(
    val perks: List<Rune>,
    val perkStyle: RuneTree,
    val perkSubStyle: RuneTree,
)
