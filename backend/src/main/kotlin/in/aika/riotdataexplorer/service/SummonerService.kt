package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.lol.LolApiClient
import `in`.aika.riotdataexplorer.api.client.lor.LorApiClient
import `in`.aika.riotdataexplorer.api.client.riot.RiotApiClient
import `in`.aika.riotdataexplorer.api.client.tft.TftApiClient
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.domain.Summoner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException

@Service
class SummonerService {

    @Autowired
    lateinit var riotApiClient: RiotApiClient

    @Autowired
    lateinit var lolApiClient: LolApiClient

    @Autowired
    lateinit var lorApiClient: LorApiClient

    @Autowired
    lateinit var tftApiClient: TftApiClient

    fun list(q: String?) = listOf("Aikain#SOLA", "Aikain#EUW", q).filterNotNull()

    fun getSummoner(gameName: String, tagLine: String): Summoner {
        try {
            val account = riotApiClient.accountByRiotId(gameName, tagLine)
            return Summoner(lolApiClient.summonerByPuuid(LolPlatform.EUN1, account.puuid))
        } catch (ex: NotFound) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Summoner not found with given game name and tag line")
        }
    }
}
