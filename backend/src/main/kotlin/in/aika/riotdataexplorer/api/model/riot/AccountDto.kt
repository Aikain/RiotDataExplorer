package `in`.aika.riotdataexplorer.api.model.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class AccountDto(
    val puuid: String,
    val gameName: String,
    val tagLine: String,
) : LogIgnoredProperties()
