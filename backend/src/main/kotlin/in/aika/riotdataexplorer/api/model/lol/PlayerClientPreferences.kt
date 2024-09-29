package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PlayerClientPreferences(
    val bannerAccent: String,
    val title: String,
    val challengeIds: List<Long>,
    val crestBorder: String,
    val prestigeCrestBorderLevel: Long,
) : LogIgnoredProperties()
