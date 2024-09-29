package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.lol.ChampionMasteryDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#champion-mastery-v4
interface LolChampionMasteryApi {

    @GetExchange("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}")
    fun championMasteriesByPuuid(@PathVariable encryptedPUUID: String): List<ChampionMasteryDto>

    @GetExchange("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/by-champion/{championId}")
    fun championMasteriesByPuuidAndChampion(
        @PathVariable encryptedPUUID: String,
        @PathVariable championId: Int,
    ): ChampionMasteryDto

    @GetExchange("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/top")
    fun championMasteriesTopByPuuid(
        @PathVariable encryptedPUUID: String,
        @RequestParam(required = false) count: Int? = 3,
    ): List<ChampionMasteryDto>

    @GetExchange("/lol/champion-mastery/v4/scores/by-puuid/{encryptedPUUID}")
    fun championMasteriesScoreByPuuid(@PathVariable encryptedPUUID: String): Int
}
