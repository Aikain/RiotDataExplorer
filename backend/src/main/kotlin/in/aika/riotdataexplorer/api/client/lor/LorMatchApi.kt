package `in`.aika.riotdataexplorer.api.client.lor

import `in`.aika.riotdataexplorer.api.model.general.match.MatchDto
import `in`.aika.riotdataexplorer.api.model.lor.InfoDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import java.util.*

// https://developer.riotgames.com/apis#lor-match-v1
interface LorMatchApi {

    @GetExchange("/lor/match/v1/matches/by-puuid/{puuid}/ids")
    fun matchesByPuuid(@PathVariable puuid: String): List<UUID>

    @GetExchange("/lor/match/v1/matches/{matchId}")
    fun matchByMatchId(@PathVariable matchId: UUID): MatchDto<InfoDto>
}
