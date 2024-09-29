package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class TournamentDto(
    val id: Int,
    val themeId: Int,
    val nameKey: String,
    val nameKeySecondary: String,
    val schedule: List<TournamentPhaseDto>
) : LogIgnoredProperties()
