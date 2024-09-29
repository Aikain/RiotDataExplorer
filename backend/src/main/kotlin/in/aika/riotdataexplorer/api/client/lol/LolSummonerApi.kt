package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.summoner.SummonerDTO
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#summoner-v4
interface LolSummonerApi {

    @GetExchange("/lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    fun summonerByAccountId(@PathVariable encryptedAccountId: String): SummonerDTO

    @GetExchange("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    fun summonerByPuuid(@PathVariable encryptedPUUID: String): SummonerDTO

    @GetExchange("/lol/summoner/v4/summoners/me")
    fun summonerMe(@RequestHeader("Authorization") bearerToken: String): SummonerDTO

    // NOTE: Consistently looking up summoner ids that don't exist will result in a blacklist.
    @GetExchange("/lol/summoner/v4/summoners/{encryptedSummonerId}")
    fun summonerBySummonerId(@PathVariable encryptedSummonerId: String): SummonerDTO
}
