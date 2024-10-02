package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.model.data.tft.*
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataWrapper
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DeepDataWrapper
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

interface TftDataDragonApi {

    @GetExchange("/cdn/{version}/data/{language}/tft-arena.json")
    fun tftArenas(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftArena>

    @GetExchange("/cdn/{version}/data/{language}/tft-augments.json")
    fun tftAugments(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftAugment>

    @GetExchange("/cdn/{version}/data/{language}/tft-champion.json")
    fun tftChampions(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftChampion>

    @GetExchange("/cdn/{version}/data/{language}/tft-charms.json")
    fun tftCharms(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftCharm>

    // TODO
    @GetExchange("/cdn/{version}/data/{language}/tft-hero-augments.json")
    fun tftHeroAugments(@PathVariable version: String, @PathVariable language: String): Any

    @GetExchange("/cdn/{version}/data/{language}/tft-item.json")
    fun tftItems(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftItem>

    @GetExchange("/cdn/{version}/data/{language}/tft-queues.json")
    fun tftQueues(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftQueue>

    @GetExchange("/cdn/{version}/data/{language}/tft-regalia.json")
    fun tftRegalia(@PathVariable version: String, @PathVariable language: String): DeepDataWrapper<TftRegaliaImage>

    @GetExchange("/cdn/{version}/data/{language}/tft-region-portals.json")
    fun tftRegionPortals(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftRegionPortal>

    @GetExchange("/cdn/{version}/data/{language}/tft-tactician.json")
    fun tftTacticians(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftTactician>

    @GetExchange("/cdn/{version}/data/{language}/tft-trait.json")
    fun tftTraits(@PathVariable version: String, @PathVariable language: String): DataWrapper<TftTrait>
}
