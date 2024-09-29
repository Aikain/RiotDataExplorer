package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueDivision
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueTier
import `in`.aika.riotdataexplorer.api.model.tft.LeagueQueue
import `in`.aika.riotdataexplorer.api.model.tft.LeagueRatedQueue
import `in`.aika.riotdataexplorer.api.routing.TftPlatform
import `in`.aika.riotdataexplorer.api.routing.TftRegion
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TftApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String,
) {

    private val tftPlatformApis: Map<TftPlatform, TftApi> = TftPlatform.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, TftApi::class.java) }
    )

    private val tftRegionApis: Map<TftRegion, TftApi> = TftRegion.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, TftApi::class.java) }
    )

    // TftLeagueApi

    fun leagueChallenger(platform: TftPlatform, queue: LeagueQueue? = LeagueQueue.RANKED_TFT) =
        tftPlatformApis.getValue(platform).leagueChallenger(queue)

    fun leagueBySummonerId(platform: TftPlatform, summonerId: String) =
        tftPlatformApis.getValue(platform).leagueBySummonerId(summonerId)

    fun leagueByTierAndDivision(
        platform: TftPlatform,
        tier: LeagueTier,
        division: LeagueDivision,
        queue: LeagueQueue? = LeagueQueue.RANKED_TFT,
        page: Int? = 1,
    ) =
        tftPlatformApis.getValue(platform).leagueByTierAndDivision(tier, division, queue, page)

    fun leagueGrandmaster(platform: TftPlatform, queue: LeagueQueue? = LeagueQueue.RANKED_TFT) =
        tftPlatformApis.getValue(platform).leagueGrandmaster(queue)

    fun leagueByLeagueId(platform: TftPlatform, leagueId: UUID) =
        tftPlatformApis.getValue(platform).leagueByLeagueId(leagueId)

    fun leagueMaster(platform: TftPlatform, queue: LeagueQueue? = LeagueQueue.RANKED_TFT) =
        tftPlatformApis.getValue(platform).leagueMaster(queue)

    fun leagueTopByQueue(
        platform: TftPlatform,
        queue: LeagueRatedQueue = LeagueRatedQueue.RANKED_TFT_TURBO,
    ) =
        tftPlatformApis.getValue(platform).leagueTopByQueue(queue)

    // TftMatchApi

    fun matchesByPuuid(
        platform: TftPlatform,
        puuid: String,
        count: Int? = 20,
        start: Int? = 0,
        startTime: Long? = null,    // epoch seconds, 2021-06-16
        endTime: Long? = null,      // epoch seconds
    ) =
        tftRegionApis.getValue(platform.toRegion()).matchesByPuuid(puuid, count, start, startTime, endTime)

    fun matchByMatchId(platform: TftPlatform, matchId: String) =
        tftRegionApis.getValue(platform.toRegion()).matchByMatchId(matchId)

    // TftSpectatorApi

    fun spectatorActiveGameByPuuid(platform: TftPlatform, encryptedPUUID: String) =
        tftPlatformApis.getValue(platform).spectatorActiveGameByPuuid(encryptedPUUID)

    fun spectatorFeaturedGames(platform: TftPlatform) =
        tftPlatformApis.getValue(platform).spectatorFeaturedGames()

    // TftStatusApi

    fun status(platform: TftPlatform) =
        tftPlatformApis.getValue(platform).status()

    // TftSummonerApi

    fun summonerByAccountId(platform: TftPlatform, encryptedAccountId: String) =
        tftPlatformApis.getValue(platform).summonerByAccountId(encryptedAccountId)

    fun summonerByPuuid(platform: TftPlatform, encryptedPUUID: String) =
        tftPlatformApis.getValue(platform).summonerByPuuid(encryptedPUUID)

    fun summonerMe(platform: TftPlatform, bearerToken: String) =
        tftPlatformApis.getValue(platform).summonerMe(bearerToken)

    fun summonerBySummonerId(platform: TftPlatform, encryptedSummonerId: String) =
        tftPlatformApis.getValue(platform).summonerBySummonerId(encryptedSummonerId)
}
