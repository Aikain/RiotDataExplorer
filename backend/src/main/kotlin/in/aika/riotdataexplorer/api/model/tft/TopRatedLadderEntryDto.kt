package `in`.aika.riotdataexplorer.api.model.tft

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class TopRatedLadderEntryDto(
    val summonerId: String, // encrypted
    val ratedTier: RatedTier,
    val ratedRating: Int,
    val wins: Int,
    val previousUpdateLadderPosition: Int,
) : LogIgnoredProperties()
