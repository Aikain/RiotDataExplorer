package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.match.MatchDto
import `in`.aika.riotdataexplorer.api.model.lol.InfoDto
import `in`.aika.riotdataexplorer.api.model.lol.MatchType
import `in`.aika.riotdataexplorer.api.model.lol.TimelineDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#match-v5
interface LolMatchApi {

    @GetExchange("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    fun matchesByPuuid(
        @PathVariable puuid: String,
        @RequestParam(required = false) startTime: Long? = null,
        @RequestParam(required = false) endTime: Long? = null,
        @RequestParam(required = false) queue: Int? = null,
        @RequestParam(required = false) type: MatchType? = null,
        @RequestParam(required = false) start: Int? = 0,
        @RequestParam(required = false) count: Int? = 20,
    ): List<String>

    @GetExchange("/lol/match/v5/matches/{matchId}")
    fun matchByMatchId(@PathVariable matchId: String): MatchDto<InfoDto>

    @GetExchange("/lol/match/v5/matches/{matchId}/timeline")
    fun matchTimelineByMatchId(@PathVariable matchId: String): TimelineDto
}
