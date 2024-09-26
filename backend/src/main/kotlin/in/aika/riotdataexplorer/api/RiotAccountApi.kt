package `in`.aika.riotdataexplorer.api

import `in`.aika.riotdataexplorer.api.model.SummonerDTO
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

interface RiotSummonerApi {

    @GetExchange("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}")
    fun byPuuid(@PathVariable encryptedPUUID: String): SummonerDTO
}
