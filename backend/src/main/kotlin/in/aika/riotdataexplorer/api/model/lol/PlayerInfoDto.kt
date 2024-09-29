package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PlayerInfoDto(
    val challenges: List<ChallengeInfo>,
    val preferences: PlayerClientPreferences,
    val totalPoints: ChallengePoints,
    val categoryPoints: Map<String, ChallengePoints>
) : LogIgnoredProperties()
