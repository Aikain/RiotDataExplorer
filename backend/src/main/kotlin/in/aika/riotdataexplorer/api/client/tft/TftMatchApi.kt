package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.model.general.match.MatchDto
import `in`.aika.riotdataexplorer.api.model.tft.InfoDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#tft-match-v1
interface TftMatchApi {

    @GetExchange("/tft/match/v1/matches/by-puuid/{puuid}/ids")
    fun matchesByPuuid(
        @PathVariable puuid: String,
        @RequestParam(required = false) count: Int? = 20,
        @RequestParam(required = false) start: Int? = 0,
        @RequestParam(required = false) startTime: Long? = null,    // epoch seconds, 2021-06-16
        @RequestParam(required = false) endTime: Long? = null,      // epoch seconds
    ): List<String>

    @GetExchange("/tft/match/v1/matches/{matchId}")
    fun matchByMatchId(@PathVariable matchId: String): MatchDto<InfoDto>
}
