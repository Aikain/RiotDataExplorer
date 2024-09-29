package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChallengePoints(
    val level: ChallengeLevel,
    val current: Long,
    val max: Long,
    val percentile: Double,
) : LogIgnoredProperties()
