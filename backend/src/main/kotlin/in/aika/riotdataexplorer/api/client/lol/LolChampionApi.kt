package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.lol.ChampionInfo
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#champion-v3
interface LolChampionApi {

    @GetExchange("/lol/platform/v3/champion-rotations")
    fun championRotations(): ChampionInfo
}
