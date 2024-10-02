package `in`.aika.riotdataexplorer.api.client.data

import `in`.aika.riotdataexplorer.api.model.data.riot.*
import org.springframework.web.service.annotation.GetExchange

interface StaticRiotApi {

    @GetExchange("/docs/lol/seasons.json")
    fun seasons(): List<Season>

    @GetExchange("/docs/lol/queues.json")
    fun queues(): List<Queue>

    @GetExchange("/docs/lol/maps.json")
    fun maps(): List<GameMap>

    @GetExchange("/docs/lol/gameModes.json")
    fun gameModes(): List<GameMode>

    @GetExchange("/docs/lol/gameTypes.json")
    fun gameTypes(): List<GameType>
}
