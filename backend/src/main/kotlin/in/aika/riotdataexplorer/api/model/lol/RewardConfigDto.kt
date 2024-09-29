package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.util.*

data class RewardConfigDto(
    val rewardValue: UUID,
    val rewardType: String,
    val maximumReward: Int,
) : LogIgnoredProperties()
