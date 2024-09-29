package `in`.aika.riotdataexplorer.api.client.lor

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.routing.LorRegion
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class LorApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String
) {

    private val lorRegionApis: Map<LorRegion, LorApi> = LorRegion.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, LorApi::class.java) }
    )

    // LorMatchApi

    fun matchesByPuuid(lorRegion: LorRegion, puuid: String) =
        lorRegionApis.getValue(lorRegion).matchesByPuuid(puuid)

    fun matchByMatchId(lorRegion: LorRegion, matchId: String) =
        lorRegionApis.getValue(lorRegion).matchByMatchId(matchId)

    // LorRankedApi

    fun rankedLeaderboard(lorRegion: LorRegion) =
        lorRegionApis.getValue(lorRegion).rankedLeaderboard()

    // LorStatusApi

    fun status(lorRegion: LorRegion) =
        lorRegionApis.getValue(lorRegion).status()
}
