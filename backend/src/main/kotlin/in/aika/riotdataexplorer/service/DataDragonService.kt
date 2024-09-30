package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.data.DataApiClient
import `in`.aika.riotdataexplorer.api.model.data.*
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.Summoner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class DataDragonService(
    private val dataApiClient: DataApiClient,
) {
    private lateinit var gameMaps: List<GameMap>
    private lateinit var gameModes: List<GameMode>
    private lateinit var gameTypes: List<GameType>
    private lateinit var queues: List<Queue>
    private lateinit var realms: Map<LolPlatform, Realm>

    init {
        runBlocking {
            awaitAll(
                async(Dispatchers.IO) {
                    gameMaps = dataApiClient.maps()
                },
                async(Dispatchers.IO) {
                    gameModes = dataApiClient.gameModes()
                },
                async(Dispatchers.IO) {
                    gameTypes = dataApiClient.gameTypes()
                },
                async(Dispatchers.IO) {
                    queues = dataApiClient.queues()
                },
                async(Dispatchers.IO) {
                    realms = LolPlatform.entries
                        .map { async(Dispatchers.IO) {
                            it to dataApiClient.realmDetails(it.toDataDragonRealm()) }
                        }
                        .awaitAll()
                        .toMap()
                },
            )
        }
    }

    private fun getCdnBaseUrl(lolPlatform: LolPlatform) =
        realms.get(lolPlatform)!!.let { "${it.cdn}/${it.v}" }

    fun fillStaticData(account: Account): Account {
        account.summoner?.let { fillStaticData(it) }
        return account
    }

    fun fillStaticData(summoner: Summoner): Summoner {
        summoner.profileIconUrl = "${getCdnBaseUrl(summoner.platform)}/img/profileicon/${summoner.profileIconId}.png"
        return summoner
    }
}
