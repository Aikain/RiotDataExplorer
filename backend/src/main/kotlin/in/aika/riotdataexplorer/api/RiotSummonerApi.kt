package `in`.aika.riotdataexplorer.api

import `in`.aika.riotdataexplorer.api.model.AccountDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

interface RiotAccountApi {

    @GetExchange("/riot/account/v1/accounts/by-puuid/{puuid}")
    fun byPuuid(@PathVariable puuid: String): AccountDto

    @GetExchange("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    fun byRiotId(@PathVariable gameName: String, @PathVariable tagLine: String): AccountDto
}
