package `in`.aika.riotdataexplorer.api.model.general.league

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MiniSeriesDTO(
    val losses: Int,
    val progress: String,
    val target: Int,
    val wins: Int,
) : LogIgnoredProperties()
