package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.model.general.league.LeagueDivision
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueListDTO
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueTier
import `in`.aika.riotdataexplorer.api.model.tft.LeagueEntryDTO
import `in`.aika.riotdataexplorer.api.model.tft.LeagueQueue
import `in`.aika.riotdataexplorer.api.model.tft.LeagueRatedQueue
import `in`.aika.riotdataexplorer.api.model.tft.TopRatedLadderEntryDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import java.util.*

// https://developer.riotgames.com/apis#tft-league-v1
interface TftLeagueApi {

    @GetExchange("/tft/league/v1/challenger")
    fun leagueChallenger(@RequestParam(required = false) queue: LeagueQueue? = LeagueQueue.RANKED_TFT): LeagueListDTO

    @GetExchange("/tft/league/v1/entries/by-summoner/{summonerId}")
    fun leagueBySummonerId(@PathVariable summonerId: String): Set<LeagueEntryDTO>

    @GetExchange("/tft/league/v1/entries/{tier}/{division}")
    fun leagueByTierAndDivision(
        @PathVariable tier: LeagueTier,
        @PathVariable division: LeagueDivision,
        @RequestParam(required = false) queue: LeagueQueue? = LeagueQueue.RANKED_TFT,
        @RequestParam(required = false) page: Int? = 1,
    ): Set<LeagueEntryDTO>

    @GetExchange("/tft/league/v1/grandmaster")
    fun leagueGrandmaster(@RequestParam(required = false) queue: LeagueQueue? = LeagueQueue.RANKED_TFT): LeagueListDTO

    @GetExchange("/tft/league/v1/leagues/{leagueId}")
    fun leagueByLeagueId(@PathVariable leagueId: UUID): LeagueListDTO

    @GetExchange("/tft/league/v1/master")
    fun leagueMaster(@RequestParam(required = false) queue: LeagueQueue? = LeagueQueue.RANKED_TFT): LeagueListDTO

    @GetExchange("/tft/league/v1/rated-ladders/{queue}/top")
    fun leagueTopByQueue(
        @PathVariable queue: LeagueRatedQueue = LeagueRatedQueue.RANKED_TFT_TURBO,
    ): List<TopRatedLadderEntryDto>
}
