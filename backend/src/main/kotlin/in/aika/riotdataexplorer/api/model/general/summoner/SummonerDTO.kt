package `in`.aika.riotdataexplorer.api.model.general.summoner

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class SummonerDTO(
    val puuid: String,
    val accountId: String,
    val id: String,
    val summonerLevel: Long,
    val profileIconId: Int,
    val revisionDate: Long,
) : LogIgnoredProperties()
