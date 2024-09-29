package `in`.aika.riotdataexplorer.api.client.valorant

import `in`.aika.riotdataexplorer.api.model.general.status.PlatformDataDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#val-status-v1
interface ValStatusApi {

    @GetExchange("/val/status/v1/platform-data")
    fun status(): PlatformDataDto
}