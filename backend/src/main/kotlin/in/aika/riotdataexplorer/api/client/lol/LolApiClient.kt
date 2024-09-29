package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueDivision
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueListDTO
import `in`.aika.riotdataexplorer.api.model.general.league.LeagueTier
import `in`.aika.riotdataexplorer.api.model.general.summoner.SummonerDTO
import `in`.aika.riotdataexplorer.api.model.lol.*
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.api.routing.LolRegion
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
class LolApiClient(
    @Value("\${RIOT_API_KEY}") riotApiKey: String,
) {

    private val lolPlatformApis: Map<LolPlatform, LolApi> = LolPlatform.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, LolApi::class.java) }
    )

    private val lolRegionApis: Map<LolRegion, LolApi> = LolRegion.entries.associateBy(
        { it },
        { Utils.createApiClient(it.host, riotApiKey, LolApi::class.java) }
    )

    // LolChallengesApi

    fun challengesConfig(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).challengesConfig()

    fun challengesPercentiles(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).challengesPercentiles()

    fun challengesConfigByChallengeId(platform: LolPlatform, challengeId: Long) =
        lolPlatformApis.getValue(platform).challengesConfigByChallengeId(challengeId)

    fun challengesLeaderboardByChallengeIdAndLevel(
        platform: LolPlatform,
        challengeId: Long,
        level: ChallengeLevel,
        limit: Int? = null,
    ): List<ApexPlayerInfoDto> {
        if (!arrayOf(ChallengeLevel.MASTER, ChallengeLevel.GRANDMASTER, ChallengeLevel.CHALLENGER).contains(level))
            throw IllegalArgumentException("Level must be MASTER, GRANDMASTER or CHALLENGER");

        return lolPlatformApis.getValue(platform).challengesLeaderboardByChallengeIdAndLevel(challengeId, level, limit)
    }

    fun challengesPercentilesByChallengeId(platform: LolPlatform, challengeId: Long) =
        lolPlatformApis.getValue(platform).challengesPercentilesByChallengeId(challengeId)

    fun challengesByPuuid(platform: LolPlatform, puuid: String) =
        lolPlatformApis.getValue(platform).challengesByPuuid(puuid)

    // LolChampionApi

    fun championRotations(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).championRotations()

    // LolChampionMasteryApi

    fun championMasteriesByPuuid(platform: LolPlatform, encryptedPUUID: String) =
        lolPlatformApis.getValue(platform).championMasteriesByPuuid(encryptedPUUID)

    fun championMasteriesByPuuidAndChampion(platform: LolPlatform, encryptedPUUID: String, championId: Int) =
        lolPlatformApis.getValue(platform).championMasteriesByPuuidAndChampion(encryptedPUUID, championId)

    fun championMasteriesByPuuid(platform: LolPlatform, encryptedPUUID: String, count: Int? = 3) =
        lolPlatformApis.getValue(platform).championMasteriesTopByPuuid(encryptedPUUID, count)

    fun championMasteriesScoreByPuuid(platform: LolPlatform, encryptedPUUID: String) =
        lolPlatformApis.getValue(platform).championMasteriesScoreByPuuid(encryptedPUUID)

    // LolClashApi
    // TODO: test clash api endpoints

    fun clashPlayersBySummonerId(platform: LolPlatform, summonerId: String) =
        lolPlatformApis.getValue(platform).clashPlayersBySummonerId(summonerId)

    fun clashTeamByTeamId(platform: LolPlatform, teamId: String) =
        lolPlatformApis.getValue(platform).clashTeamByTeamId(teamId)

    fun clashTournaments(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).clashTournaments()

    fun clashTournamentByTeamId(platform: LolPlatform, teamId: String) =
        lolPlatformApis.getValue(platform).clashTournamentByTeamId(teamId)

    fun clashTournamentByTournamentId(platform: LolPlatform, tournamentId: Int) =
        lolPlatformApis.getValue(platform).clashTournamentByTournamentId(tournamentId)

    // LolLeagueApi

    fun leagueChallengerByQueue(platform: LolPlatform, queue: LeagueQueue) =
        lolPlatformApis.getValue(platform).leagueChallengerByQueue(queue)

    fun leagueBySummoner(platform: LolPlatform, encryptedSummonerId: String) =
        lolPlatformApis.getValue(platform).leagueBySummoner(encryptedSummonerId)

    fun leagueByQueueAndTierAndDivision(
        platform: LolPlatform,
        queue: LeagueQueue,
        tier: LeagueTier,
        division: LeagueDivision,
        page: Int? = 1
    ) =
        lolPlatformApis.getValue(platform).leagueByQueueAndTierAndDivision(queue, tier, division, page)

    fun leagueGrandmasterByQueue(platform: LolPlatform, queue: LeagueQueue) =
        lolPlatformApis.getValue(platform).leagueGrandmasterByQueue(queue)

    fun leagueByLeagueId(platform: LolPlatform, leagueId: UUID): LeagueListDTO {
        try {
            return lolPlatformApis.getValue(platform).leagueByLeagueId(leagueId)
        } catch (ex: HttpClientErrorException.NotFound) {
            logger.warn { "Consistently looking up league ids that don't exist will result in a blacklist." }
            throw ex
        }
    }

    fun leagueMasterByQueue(platform: LolPlatform, queue: LeagueQueue) =
        lolPlatformApis.getValue(platform).leagueMasterByQueue(queue)

    // LolLeagueExpApi

    fun leagueExpByQueueAndTierAndDivision(
        platform: LolPlatform,
        queue: LeagueExpQueue,
        tier: LeagueExpTier,
        division: LeagueDivision,
        page: Int? = 1
    ) =
        lolPlatformApis.getValue(platform).leagueExpByQueueAndTierAndDivision(queue, tier, division, page)

    // LolMatchApi

    fun matchesByPuuid(
        platform: LolPlatform,
        puuid: String,
        startTime: Long? = null,
        endTime: Long? = null,
        queue: Int? = null,
        type: MatchType? = null,
        start: Int? = 0,
        count: Int? = 20,
    ) =
        lolRegionApis.getValue(platform.toRegion()).matchesByPuuid(puuid, startTime, endTime, queue, type, start, count)

    fun matchByMatchId(platform: LolPlatform, matchId: String) =
        lolRegionApis.getValue(platform.toRegion()).matchByMatchId(matchId)

    fun matchTimelineByMatchId(platform: LolPlatform, matchId: String) =
        lolRegionApis.getValue(platform.toRegion()).matchTimelineByMatchId(matchId)

    // LolSpectatorApi

    fun spectatorActiveGameByPuuid(platform: LolPlatform, encryptedPUUID: String) =
        lolPlatformApis.getValue(platform).spectatorActiveGameByPuuid(encryptedPUUID)

    fun spectatorFeaturedGames(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).spectatorFeaturedGames()

    // LolStatusApi

    fun status(platform: LolPlatform) =
        lolPlatformApis.getValue(platform).status()

    // LolSummonerApi

    fun summonerByAccountId(platform: LolPlatform, encryptedAccountId: String) =
        lolPlatformApis.getValue(platform).summonerByAccountId(encryptedAccountId)

    fun summonerByPuuid(platform: LolPlatform, encryptedPUUID: String) =
        lolPlatformApis.getValue(platform).summonerByPuuid(encryptedPUUID)

    fun summonerMe(platform: LolPlatform, bearerToken: String) =
        lolPlatformApis.getValue(platform).summonerMe(bearerToken)

    fun summonerBySummonerId(platform: LolPlatform, encryptedSummonerId: String): SummonerDTO {
        try {
            return lolPlatformApis.getValue(platform).summonerBySummonerId(encryptedSummonerId)
        } catch (ex: HttpClientErrorException.NotFound) {
            logger.warn { "Consistently looking up summoner ids that don't exist will result in a blacklist." }
            throw ex
        }
    }
}
