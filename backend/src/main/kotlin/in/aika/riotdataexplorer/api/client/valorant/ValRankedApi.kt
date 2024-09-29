package `in`.aika.riotdataexplorer.api.client.valorant

import `in`.aika.riotdataexplorer.api.model.valorant.LeaderboardDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#val-ranked-v1
interface ValRankedApi {

    @GetExchange("/val/ranked/v1/leaderboards/by-act/{actId}")
    fun leaderboardByActId(
        @PathVariable actId: String,
        @RequestParam(required = false) size: Int? = 200,
        @RequestParam(required = false) startIndex: Int? = 0,
    ): LeaderboardDto
}