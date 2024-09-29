package `in`.aika.riotdataexplorer.api.client.lor

import `in`.aika.riotdataexplorer.api.model.lor.LeaderboardDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#lor-ranked-v1
interface LorRankedApi {

    // Note: The leaderboard is updated once an hour.
    @GetExchange("/lor/ranked/v1/leaderboards")
    fun rankedLeaderboard(): LeaderboardDto
}
