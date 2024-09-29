package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.general.league.MiniSeriesDTO
import java.util.*

data class LeagueEntryDTO(
    val leagueId: UUID,
    val summonerId: String, // encrypted
    val queueType: String,
    val tier: String, // TODO: enum?
    val rank: String, // TODO: enum? division
    val leaguePoints: Int,
    val wins: Int,
    val losses: Int,
    val hotStreak: Boolean,
    val veteran: Boolean,
    val freshBlood: Boolean,
    val inactive: Boolean,
    val miniSeries: MiniSeriesDTO?,
) : LogIgnoredProperties()
