package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.league.LeagueDivision
import `in`.aika.riotdataexplorer.api.model.lol.LeagueEntryDTO
import `in`.aika.riotdataexplorer.api.model.lol.LeagueExpQueue
import `in`.aika.riotdataexplorer.api.model.lol.LeagueExpTier
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#league-exp-v4
interface LolLeagueExpApi {

    @GetExchange("/lol/league-exp/v4/entries/{queue}/{tier}/{division}")
    fun leagueExpByQueueAndTierAndDivision(
        @PathVariable queue: LeagueExpQueue,
        @PathVariable tier: LeagueExpTier,
        @PathVariable division: LeagueDivision,
        @RequestParam(required = false) page: Int? = 1,
    ): Set<LeagueEntryDTO>
}
