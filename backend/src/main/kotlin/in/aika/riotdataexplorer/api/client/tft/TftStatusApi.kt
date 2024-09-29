package `in`.aika.riotdataexplorer.api.client.tft

import `in`.aika.riotdataexplorer.api.model.general.status.PlatformDataDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#tft-status-v1
interface TftStatusApi {

    @GetExchange("/tft/status/v1/platform-data")
    fun status(): PlatformDataDto
}
