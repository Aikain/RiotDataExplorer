package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.data.DataApiClient
import `in`.aika.riotdataexplorer.api.model.data.ProfileIcon
import `in`.aika.riotdataexplorer.api.model.data.Realm
import `in`.aika.riotdataexplorer.api.model.data.SummonerSpell
import `in`.aika.riotdataexplorer.api.model.data.lol.Champion
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMap
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMode
import `in`.aika.riotdataexplorer.api.model.data.riot.GameType
import `in`.aika.riotdataexplorer.api.model.data.riot.Queue
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.Summoner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

// TODO: remove hardcoded language and version
val LANGUAGE = "en_US"
val VERSION = "14.19.1"

@Service
class DataDragonService(
    private val dataApiClient: DataApiClient,
) {
    private lateinit var gameMaps: List<GameMap>
    private lateinit var gameModes: List<GameMode>
    private lateinit var gameTypes: List<GameType>
    private lateinit var queues: List<Queue>
    private lateinit var realms: Map<LolPlatform, Realm>
    private lateinit var profileIcons: Map<LolPlatform, Map<String, ProfileIcon>>
    private lateinit var champions: Map<LolPlatform, Map<String, Champion>>
    private lateinit var summonerSpells: Map<LolPlatform, Map<String, SummonerSpell>>

    init {
        runBlocking {
            awaitAll(
                async(Dispatchers.IO) {
                    gameMaps = dataApiClient.maps().map(::fillMapStaticData)
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
                async(Dispatchers.IO) {
                    // TODO: find out whether it is necessary to apply for each region separately
                    val data = dataApiClient.profileIcons(VERSION, LANGUAGE)
                    profileIcons = LolPlatform.entries.associateWith { data }
                },
                async(Dispatchers.IO) {
                    // TODO: find out whether it is necessary to apply for each region separately
                    val data = dataApiClient.championsFull(VERSION, LANGUAGE)
                    champions = LolPlatform.entries.associateWith { data }
                },
                async(Dispatchers.IO) {
                    // TODO: find out whether it is necessary to apply for each region separately
                    val data = dataApiClient.summonerSpells(VERSION, LANGUAGE)
                    summonerSpells = LolPlatform.entries.associateWith { data }
                },
            )
        }
    }

    private fun getCdnBaseUrlWithVersion() = "https://ddragon.leagueoflegends.com/cdn/$VERSION"

    private fun fillMapStaticData(map: GameMap): GameMap = map.apply {
        minimapUrl = "${getCdnBaseUrlWithVersion()}/img/map/map${map.mapId}.png"
    }

    fun fillStaticData(account: Account): Account = account.apply {
        summoner?.let(::fillStaticData)
    }

    fun fillStaticData(summoner: Summoner): Summoner = summoner.apply {
        profileIcon = profileIcons.get(summoner.platform)?.get(summoner.profileIconId.toString())
    }

    fun getGameMap(mapId: Int): GameMap =
        gameMaps.find { it.mapId == mapId } ?: GameMap.UNKNOWN

    fun getGameMode(gameMode: String): GameMode =
        gameModes.find { it.gameMode == gameMode } ?: GameMode.UNKNOWN

    fun getGameType(gameType: String): GameType =
        gameTypes.find { it.gameType == "${gameType}_GAME" } ?: GameType.UNKNOWN

    fun getQueue(queueId: Int): Queue =
        queues.find { it.queueId == queueId } ?: Queue.UNKNOWN

    fun getChampion(championId: Int): Champion =
        // TODO: remove hardcoded platform
        champions[LolPlatform.EUN1]?.get(championId.toString()) ?: Champion.UNKNOWN

    fun getSummonerSpell(summonerSpellId: Long): SummonerSpell =
        // TODO: remove hardcoded platform
        summonerSpells[LolPlatform.EUN1]?.get(summonerSpellId.toString()) ?: SummonerSpell.UNKNOWN
}
