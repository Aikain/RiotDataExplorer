package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.data.lol.Champion
import `in`.aika.riotdataexplorer.domain.Views

@JsonView(Views.CurrentGameGet::class)
data class BannedChampion(
    val pickTurn: Int,
    val champion: Champion,
    val teamId: Long,
)
