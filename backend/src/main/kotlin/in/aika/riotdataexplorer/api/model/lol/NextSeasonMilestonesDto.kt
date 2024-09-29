package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class NextSeasonMilestonesDto(
    val requireGradeCounts: Map<String, Int>,
    val rewardMarks: Int,
    val bonus: Boolean,
    val rewardConfig: RewardConfigDto,
    val totalGamesRequires: Int,
) : LogIgnoredProperties()
