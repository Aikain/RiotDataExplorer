package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Challenge(
    val id: Long,
    val name: String,
    val description: String,
    val shortDescription: String,
    val hasLeaderboard: Boolean,
    val levelToIconPath: Map<String, String>, // TODO: fill image paths?
    val thresholds: Map<String, ChallengeThreshold>
) : LogIgnoredProperties()
