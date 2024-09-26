package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.RiotAccountApi
import `in`.aika.riotdataexplorer.api.RiotSummonerApi
import `in`.aika.riotdataexplorer.domain.Summoner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException

@Service
class SummonerService {

    @Autowired
    lateinit var riotAccountApi: RiotAccountApi

    @Autowired
    lateinit var riotSummonerApi: RiotSummonerApi

    fun list(q: String?) = listOf("Aikain#SOLA", "Aikain#EUW", q).filterNotNull()

    fun getSummoner(gameName: String, tagLine: String): Summoner {
        try {
            return Summoner(riotSummonerApi.byPuuid(riotAccountApi.byRiotId(gameName, tagLine).puuid))
        } catch (ex: NotFound) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Summoner not found with given game name and tag line")
        }
    }
}
