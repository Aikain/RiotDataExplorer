package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.model.data.ProfileIcon
import `in`.aika.riotdataexplorer.api.model.data.Realm
import `in`.aika.riotdataexplorer.api.model.data.SummonerSpell
import `in`.aika.riotdataexplorer.api.model.data.lol.*
import `in`.aika.riotdataexplorer.api.model.data.wrapper.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

interface LolDataDragonApi {

    @GetExchange("/api/versions.json")
    fun versions(): List<String>

    @GetExchange("/realms/{realm}.json")
    fun realmDetails(@PathVariable realm: String): Realm

    @GetExchange("/cdn/languages.json")
    fun languages(): List<String>

    @GetExchange("/cdn/{version}/data/{language}/challenges.json")
    fun challenges(@PathVariable version: String, @PathVariable language: String): List<Challenge>

    @GetExchange("/cdn/{version}/data/{language}/champion.json")
    fun champions(@PathVariable version: String, @PathVariable language: String): ChampionWrapper<SimpleChampion>

    @GetExchange("/cdn/{version}/data/{language}/championFull.json")
    fun championsFull(@PathVariable version: String, @PathVariable language: String): ChampionWrapper<Champion>

    @GetExchange("/cdn/{version}/data/{language}/champion/{champion}.json")
    fun champion(@PathVariable version: String, @PathVariable language: String, @PathVariable champion: String): ChampionWrapper<Champion>

    @GetExchange("/cdn/{version}/data/{language}/item.json")
    fun items(@PathVariable version: String, @PathVariable language: String): ItemWrapper<Item>

    @GetExchange("/cdn/{version}/data/{language}/item-modifiers.json")
    fun itemModifiers(@PathVariable version: String, @PathVariable language: String): DataWrapper<ItemModifier>

    @GetExchange("/cdn/{version}/data/{language}/language.json")
    fun languages(@PathVariable version: String, @PathVariable language: String): LanguageWrapper

    @GetExchange("/cdn/{version}/data/{language}/map.json")
    fun maps(@PathVariable version: String, @PathVariable language: String): DataWrapper<GameMap>

    @GetExchange("/cdn/{version}/data/{language}/mission-assets.json")
    fun missionsAssets(@PathVariable version: String, @PathVariable language: String): DataWrapper<MissionAsset>

    @GetExchange("/cdn/{version}/data/{language}/profileicon.json")
    fun profileIcons(@PathVariable version: String, @PathVariable language: String): DataWrapper<ProfileIcon>

    @GetExchange("/cdn/{version}/data/{language}/runesReforged.json")
    fun runesReforged(@PathVariable version: String, @PathVariable language: String): List<RuneTree>

    @GetExchange("/cdn/{version}/data/{language}/spellbuffs.json")
    fun spellBuffs(@PathVariable version: String, @PathVariable language: String): SpellBuffWrapper

    // TODO
    @GetExchange("/cdn/{version}/data/{language}/sticker.json")
    fun stickers(@PathVariable version: String, @PathVariable language: String): Any

    @GetExchange("/cdn/{version}/data/{language}/summoner.json")
    fun summonerSpells(@PathVariable version: String, @PathVariable language: String): DataWrapper<SummonerSpell>
}
