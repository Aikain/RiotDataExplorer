package `in`.aika.riotdataexplorer.api.client.riot

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.routing.RiotRegion
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class RiotApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String,
    @Value("\${RIOT_NEAREST_CLUSTER:EUROPE}") riotNearestCluster: RiotRegion,
) : RiotApi {

    private val riotAccountApi: RiotAccountApi = Utils.createApiClient(riotNearestCluster.host, riotApiKey, RiotAccountApi::class.java)

    // RiotAccountApi

    override fun accountByPuuid(puuid: String) =
        riotAccountApi.accountByPuuid(puuid)

    override fun accountByRiotId(gameName: String, tagLine: String) =
        riotAccountApi.accountByRiotId(gameName, tagLine)

    override fun activeShardsByGameAndPuuid(game: String, puuid: String) =
        riotAccountApi.activeShardsByGameAndPuuid(game, puuid)
}
