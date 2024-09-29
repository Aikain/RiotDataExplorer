package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.model.general.summoner.SummonerDTO
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#tft-summoner-v1
interface TftSummonerApi {

    @GetExchange("/tft/summoner/v1/summoners/by-account/{encryptedAccountId}")
    fun summonerByAccountId(@PathVariable encryptedAccountId: String): SummonerDTO

    @GetExchange("/tft/summoner/v1/summoners/by-puuid/{encryptedPUUID}")
    fun summonerByPuuid(@PathVariable encryptedPUUID: String): SummonerDTO

    @GetExchange("/tft/summoner/v1/summoners/me")
    fun summonerMe(@RequestHeader("Authorization") bearerToken: String): SummonerDTO

    @GetExchange("/tft/summoner/v1/summoners/{encryptedSummonerId}")
    fun summonerBySummonerId(@PathVariable encryptedSummonerId: String): SummonerDTO
}
