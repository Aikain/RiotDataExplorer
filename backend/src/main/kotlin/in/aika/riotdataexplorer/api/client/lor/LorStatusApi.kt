package `in`.aika.riotdataexplorer.api.client.lor

import `in`.aika.riotdataexplorer.api.model.general.status.PlatformDataDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#lor-status-v1
interface LorStatusApi {

    @GetExchange("/lor/status/v1/platform-data")
    fun status(): PlatformDataDto
}
