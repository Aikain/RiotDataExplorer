package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.Utils
import org.springframework.stereotype.Component

@Component
class DataApiClient : LolDataDragonApi, StaticRiotApi {

    private val lolDataDragonApi: LolDataDragonApi = Utils.createLolDataDragonApiClient()
    private val staticRiotApi: StaticRiotApi = Utils.createStaticRiotApiClient()

    override fun versions() =
        lolDataDragonApi.versions()

    override fun realmDetails(realm: String) =
        lolDataDragonApi.realmDetails(realm)

    override fun languages() =
        lolDataDragonApi.languages()

    override fun champions(version: String, language: String) =
        lolDataDragonApi.champions(version, language)

    override fun champion(version: String, language: String, champion: String) =
        lolDataDragonApi.champion(version, language, champion)

    override fun items(version: String, language: String) =
        lolDataDragonApi.items(version, language)

    override fun summonerSpells(version: String, language: String) =
        lolDataDragonApi.summonerSpells(version, language)

    override fun profileIcons(version: String, language: String) =
        lolDataDragonApi.profileIcons(version, language)

    override fun seasons() =
        staticRiotApi.seasons()

    override fun queues() =
        staticRiotApi.queues()

    override fun maps() =
        staticRiotApi.maps()

    override fun gameModes() =
        staticRiotApi.gameModes()

    override fun gameTypes() =
        staticRiotApi.gameTypes()
}
