package `in`.aika.riotdataexplorer.api.client.riot

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.model.riot.Game
import `in`.aika.riotdataexplorer.api.routing.RiotRegion
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class RiotApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String,
    @Value("\${RIOT_NEAREST_CLUSTER:EUROPE}") riotNearestCluster: RiotRegion,
) {

    private val riotAccountApi: RiotAccountApi = Utils.createApiClient(riotNearestCluster.host, riotApiKey, RiotAccountApi::class.java)

    // RiotAccountApi

    fun accountByPuuid(puuid: String) =
        riotAccountApi.accountByPuuid(puuid)

    fun accountByRiotId(gameName: String, tagLine: String) =
        riotAccountApi.accountByRiotId(gameName, tagLine)

    fun activeShardsByGameAndPuuid(game: Game, puuid: String) =
        riotAccountApi.activeShardsByGameAndPuuid(game.toPathVariable(), puuid)
}
