package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChallengeThreshold(
    val value: Long,
    val rewards: List<ChallengeReward>
) : LogIgnoredProperties()
