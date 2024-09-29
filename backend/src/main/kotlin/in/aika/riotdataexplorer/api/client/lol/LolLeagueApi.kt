package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.league.LeagueDivision
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueListDTO
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueTier
import `in`.aika.riotdataexplorer.api.model.lol.LeagueEntryDTO
import `in`.aika.riotdataexplorer.api.model.lol.LeagueQueue
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import java.util.*

// https://developer.riotgames.com/apis#league-v4
interface LolLeagueApi {

    @GetExchange("/lol/league/v4/challengerleagues/by-queue/{queue}")
    fun leagueChallengerByQueue(@PathVariable queue: LeagueQueue): LeagueListDTO

    @GetExchange("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun leagueBySummoner(@PathVariable encryptedSummonerId: String): Set<LeagueEntryDTO>

    @GetExchange("/lol/league/v4/entries/{queue}/{tier}/{division}")
    fun leagueByQueueAndTierAndDivision(
        @PathVariable queue: LeagueQueue,
        @PathVariable tier: LeagueTier,
        @PathVariable division: LeagueDivision,
        @RequestParam(required = false) page: Int? = 1,
    ): Set<LeagueEntryDTO>

    @GetExchange("/lol/league/v4/grandmasterleagues/by-queue/{queue}")
    fun leagueGrandmasterByQueue(@PathVariable queue: LeagueQueue): LeagueListDTO

    // NOTE: Consistently looking up league ids that don't exist will result in a blacklist.
    @GetExchange("/lol/league/v4/leagues/{leagueId}")
    fun leagueByLeagueId(@PathVariable leagueId: UUID): LeagueListDTO

    @GetExchange("/lol/league/v4/masterleagues/by-queue/{queue}")
    fun leagueMasterByQueue(@PathVariable queue: LeagueQueue): LeagueListDTO
}
