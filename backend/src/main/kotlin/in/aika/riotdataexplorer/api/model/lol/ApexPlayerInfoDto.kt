package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ApexPlayerInfoDto(
    val puuid: String,
    val value: Double,
    val position: Int,
) : LogIgnoredProperties()
