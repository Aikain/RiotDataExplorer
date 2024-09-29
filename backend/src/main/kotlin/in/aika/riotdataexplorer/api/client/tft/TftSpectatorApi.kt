package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.model.general.spectator.CurrentGameInfo
import `in`.aika.riotdataexplorer.api.model.general.spectator.FeaturedGames
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#spectator-tft-v5
interface TftSpectatorApi {

    @GetExchange("/lol/spectator/tft/v5/active-games/by-puuid/{encryptedPUUID}")
    fun spectatorActiveGameByPuuid(@PathVariable encryptedPUUID: String): CurrentGameInfo

    @GetExchange("/lol/spectator/tft/v5/featured-games")
    fun spectatorFeaturedGames(): FeaturedGames
}
