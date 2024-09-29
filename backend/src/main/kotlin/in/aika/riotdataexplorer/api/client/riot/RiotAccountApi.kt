package `in`.aika.riotdataexplorer.api.client.riot

import `in`.aika.riotdataexplorer.api.model.riot.AccountDto
import `in`.aika.riotdataexplorer.api.model.riot.ActiveShardDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#account-v1
interface RiotAccountApi {

    @GetExchange("/riot/account/v1/accounts/by-puuid/{puuid}")
    fun accountByPuuid(@PathVariable puuid: String): AccountDto

    @GetExchange("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    fun accountByRiotId(@PathVariable gameName: String, @PathVariable tagLine: String): AccountDto

    @GetExchange("/riot/account/v1/active-shards/by-game/{game}/by-puuid/{puuid}")
    fun activeShardsByGameAndPuuid(@PathVariable game: String, @PathVariable puuid: String): ActiveShardDto
}
