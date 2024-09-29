package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.general.status.PlatformDataDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#lol-status-v4
interface LolStatusApi {

    @GetExchange("/lol/status/v4/platform-data")
    fun status(): PlatformDataDto
}
