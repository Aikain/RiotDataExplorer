package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.lol.ApexPlayerInfoDto
import `in`.aika.riotdataexplorer.api.model.lol.ChallengeConfigInfoDto
import `in`.aika.riotdataexplorer.api.model.lol.ChallengeLevel
import `in`.aika.riotdataexplorer.api.model.lol.PlayerInfoDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#lol-challenges-v1
interface LolChallengesApi {

    @GetExchange("/lol/challenges/v1/challenges/config")
    fun challengesConfig(): List<ChallengeConfigInfoDto>

    @GetExchange("/lol/challenges/v1/challenges/percentiles")
    fun challengesPercentiles(): Map<Long, Map<ChallengeLevel, Double>>

    @GetExchange("/lol/challenges/v1/challenges/{challengeId}/config")
    fun challengesConfigByChallengeId(@PathVariable challengeId: Long): ChallengeConfigInfoDto

    @GetExchange("/lol/challenges/v1/challenges/{challengeId}/leaderboards/by-level/{level}")
    fun challengesLeaderboardByChallengeIdAndLevel(
        @PathVariable challengeId: Long,
        @PathVariable level: ChallengeLevel,
        @RequestParam(required = false) limit: Int? = null
    ): List<ApexPlayerInfoDto>

    @GetExchange("/lol/challenges/v1/challenges/{challengeId}/percentiles")
    fun challengesPercentilesByChallengeId(@PathVariable challengeId: Long): Map<ChallengeLevel, Double>

    @GetExchange("/lol/challenges/v1/player-data/{puuid}")
    fun challengesByPuuid(@PathVariable puuid: String): PlayerInfoDto
}
