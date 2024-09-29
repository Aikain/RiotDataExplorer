package `in`.aika.riotdataexplorer.api.model.general.league

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class LeagueItemDTO(
    val summonerId: String, // encrypted
    val leaguePoints: Int,
    val rank: String,
    val wins: Int,
    val losses: Int,
    val freshBlood: Boolean,
    val veteran: Boolean,
    val hotStreak: Boolean,
    val inactive: Boolean,
    val miniSeries: MiniSeriesDTO?,
) : LogIgnoredProperties()
