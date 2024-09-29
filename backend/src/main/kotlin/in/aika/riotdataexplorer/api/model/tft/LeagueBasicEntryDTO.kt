package `in`.aika.riotdataexplorer.api.model.tft

import `in`.aika.riotdataexplorer.api.model.general.league.MiniSeriesDTO
import java.util.*

data class LeagueBasicEntryDTO(
    override val puuid: String, // encrypted
    override val summonerId: String, // encrypted, except when queueType == RANKED_TFT_DOUBLE_UP ?
    override val queueType: String,

    override val wins: Int,
    override val losses: Int,

    val leagueId: UUID,
    val tier: String, // TODO: enum?
    val rank: String, // TODO: enum? division
    val leaguePoints: Int,
    val hotStreak: Boolean,
    val veteran: Boolean,
    val freshBlood: Boolean,
    val inactive: Boolean,
    val miniSeries: MiniSeriesDTO?,
) : LeagueEntryDTO()
