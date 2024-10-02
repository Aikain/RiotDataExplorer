package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChallengeReward(
    val category: String, // TODO: enum? TITLE, ... ?
    val quantity: Int,
    val title: String,
) : LogIgnoredProperties()
