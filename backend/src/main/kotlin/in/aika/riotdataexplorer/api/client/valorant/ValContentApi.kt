package `in`.aika.riotdataexplorer.api.client.valorant

import `in`.aika.riotdataexplorer.api.model.valorant.ContentDto
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#val-content-v1
interface ValContentApi {

    @GetExchange("/val/content/v1/contents")
    fun content(): ContentDto
}
