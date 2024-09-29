package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.spectator.CurrentGameInfo
import `in`.aika.riotdataexplorer.api.model.general.spectator.FeaturedGames
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#spectator-v5
interface LolSpectatorApi {

    @GetExchange("/lol/spectator/v5/active-games/by-summoner/{encryptedPUUID}")
    fun spectatorActiveGameByPuuid(@PathVariable encryptedPUUID: String): CurrentGameInfo

    @GetExchange("/lol/spectator/v5/featured-games")
    fun spectatorFeaturedGames(): FeaturedGames
}
