package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.model.data.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

interface LolDataDragonApi {

    @GetExchange("/api/versions.json")
    fun versions(): List<String>

    @GetExchange("/realms/{realm}.json")
    fun realmDetails(@PathVariable realm: String): Realm

    @GetExchange("/cnd/languages.json")
    fun languages(): List<String>

    @GetExchange("/cnd/{version}/data/{language}/champion.json")
    fun champions(@PathVariable version: String, @PathVariable language: String): ChampionDataWrapper<SimpleChampion>

    @GetExchange("/cnd/{version}/data/{language}/champion/{champion}.json")
    fun champion(@PathVariable version: String, @PathVariable language: String, @PathVariable champion: String): ChampionDataWrapper<Champion>

    @GetExchange("/cnd/{version}/data/{language}/item.json")
    fun items(@PathVariable version: String, @PathVariable language: String): ItemDataWrapper

    @GetExchange("/cnd/{version}/data/{language}/summoner.json")
    fun summonerSpells(@PathVariable version: String, @PathVariable language: String): DataWrapper<SummonerSpell>

    @GetExchange("/cnd/{version}/data/{language}/profileicon.json")
    fun profileIcons(@PathVariable version: String, @PathVariable language: String): DataWrapper<ProfileIcon>
}
