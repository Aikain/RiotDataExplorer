package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.lol.LolApiClient
import `in`.aika.riotdataexplorer.api.model.general.summoner.SummonerDTO
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.api.routing.LolRegion
import `in`.aika.riotdataexplorer.domain.Summoner
import `in`.aika.riotdataexplorer.repository.SummonerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound

@Service
class SummonerService(
    private val lolApiClient: LolApiClient,
    private val summonerRepository: SummonerRepository,
) {

    // TODO: guess better order by IP or something?
    fun getRegions() = listOf(LolRegion.EUROPE, LolRegion.AMERICAS, LolRegion.ASIA, LolRegion.SEA)

    fun findSummoner(puuid: String, tagLine: String): Summoner? {
        LolPlatform.fromTagLine(tagLine)?.let {
            try {
                return getSummoner(lolApiClient.summonerByPuuid(it, puuid), it)
            } catch (ignored: NotFound) {}
        }
        getRegions().forEach {
            if (lolApiClient.matchesByPuuid(it, puuid, count = 1).isNotEmpty()) {
                LolPlatform.byRegion(it).forEach{
                    try {
                        return getSummoner(lolApiClient.summonerByPuuid(it, puuid), it)
                    } catch (ignored: NotFound) {}
                }
            }
        }
        return null
    }

    fun getSummoner(summonerDTO: SummonerDTO, platform: LolPlatform): Summoner =
        summonerRepository.findByIdOrNull(summonerDTO.id) ?: summonerRepository.save(Summoner(summonerDTO, platform))
}
