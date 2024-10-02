package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.Utils
import `in`.aika.riotdataexplorer.api.model.data.ProfileIcon
import `in`.aika.riotdataexplorer.api.model.data.Realm
import `in`.aika.riotdataexplorer.api.model.data.SummonerSpell
import `in`.aika.riotdataexplorer.api.model.data.lol.*
import `in`.aika.riotdataexplorer.api.model.data.tft.*
import org.springframework.stereotype.Component

@Component
class DataApiClient {

    private val lolDataDragonApi: LolDataDragonApi = Utils.createLolDataDragonApiClient()
    private val staticRiotApi: StaticRiotApi = Utils.createStaticRiotApiClient()
    private val tftDataDragonApi: TftDataDragonApi = Utils.createTftDataDragonApiClient()

    fun versions(): List<String> =
        lolDataDragonApi.versions()

    fun realmDetails(realm: String): Realm =
        lolDataDragonApi.realmDetails(realm)

    fun languages(): List<String> =
        lolDataDragonApi.languages()

    fun challenges(version: String, language: String): List<Challenge> =
        lolDataDragonApi.challenges(version, language)

    fun champions(version: String, language: String): Map<String, SimpleChampion> =
        lolDataDragonApi.champions(version, language).getFilledData()
            .map { it.value.key to it.value }
            .toMap()

    fun championsFull(version: String, language: String): Map<String, Champion> =
        lolDataDragonApi.championsFull(version, language).getFilledData()
            .map { it.value.key to it.value }
            .toMap()

    fun champion(version: String, language: String, champion: String): Champion? =
        lolDataDragonApi.champion(version, language, champion).getFilledData().get(champion)

    fun items(version: String, language: String): Map<String, Item> =
        lolDataDragonApi.items(version, language).getFilledData()

    fun itemModifiers(version: String, language: String): Map<String, ItemModifier> =
        lolDataDragonApi.itemModifiers(version, language).getFilledData()

    fun languages(version: String, language: String): Map<String, String> =
        lolDataDragonApi.languages(version, language).data

    fun maps(version: String, language: String): Map<String, GameMap> =
        lolDataDragonApi.maps(version, language).getFilledData()

    fun missionsAssets(version: String, language: String): Map<String, MissionAsset> =
        lolDataDragonApi.missionsAssets(version, language).getFilledData()

    fun profileIcons(version: String, language: String): Map<String, ProfileIcon> =
        lolDataDragonApi.profileIcons(version, language).getFilledData()

    fun runesReforged(version: String, language: String): List<RuneTree> =
        lolDataDragonApi.runesReforged(version, language)

    fun spellBuffs(version: String, language: String): List<SpellBuff> =
        lolDataDragonApi.spellBuffs(version, language).spellBuffs

    // TODO
    fun stickers(version: String, language: String): Any =
        lolDataDragonApi.stickers(version, language)

    fun summonerSpells(version: String, language: String): Map<String, SummonerSpell> =
        lolDataDragonApi.summonerSpells(version, language).getFilledData()
            .map { it.value.key to it.value }
            .toMap()

    fun seasons() =
        staticRiotApi.seasons()

    fun queues() =
        staticRiotApi.queues()

    fun maps() =
        staticRiotApi.maps()

    fun gameModes() =
        staticRiotApi.gameModes()

    fun gameTypes() =
        staticRiotApi.gameTypes()

    fun tftArenas(version: String, language: String): Map<String, TftArena> =
        tftDataDragonApi.tftArenas(version, language).getFilledData()

    fun tftAugments(version: String, language: String): Map<String, TftAugment> =
        tftDataDragonApi.tftAugments(version, language).getFilledData()

    fun tftChampions(version: String, language: String): Map<String, TftChampion> =
        tftDataDragonApi.tftChampions(version, language).getFilledData()

    fun tftCharms(version: String, language: String): Map<String, TftCharm> =
        tftDataDragonApi.tftCharms(version, language).getFilledData()

    // TODO
    fun tftHeroAugments(version: String, language: String): Any =
        tftDataDragonApi.tftHeroAugments(version, language)

    fun tftItems(version: String, language: String): Map<String, TftItem> =
        tftDataDragonApi.tftItems(version, language).getFilledData()

    fun tftQueues(version: String, language: String): Map<String, TftQueue> =
        tftDataDragonApi.tftQueues(version, language).getFilledData()

    fun tftRegalia(version: String, language: String): Map<String, Map<String, TftRegaliaImage>> =
        tftDataDragonApi.tftRegalia(version, language).getFilledData()

    fun tftRegionPortals(version: String, language: String): Map<String, TftRegionPortal> =
        tftDataDragonApi.tftRegionPortals(version, language).getFilledData()

    fun tftTacticians(version: String, language: String): Map<String, TftTactician> =
        tftDataDragonApi.tftTacticians(version, language).getFilledData()

    fun tftTraits(version: String, language: String): Map<String, TftTrait> =
        tftDataDragonApi.tftTraits(version, language).getFilledData()
}
