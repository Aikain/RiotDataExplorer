package `in`.aika.riotdataexplorer.api.client.valorant

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.routing.ValRegion
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ValApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String
) {

    private val valRegionApis: Map<ValRegion, ValApi> = ValRegion.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, ValApi::class.java) }
    )

    // TODO: test this api client methods

    // ValContentApi

    fun content(region: ValRegion) =
        valRegionApis.getValue(region).content()

    // ValRankedApi

    fun leaderboardByActId(
        region: ValRegion,
        actId: String,
        size: Int? = 200,
        startIndex: Int? = 0,
    ) =
        valRegionApis.getValue(region).leaderboardByActId(actId, size, startIndex)

    // ValStatusApi

    fun status(region: ValRegion) =
        valRegionApis.getValue(region).status()
}
