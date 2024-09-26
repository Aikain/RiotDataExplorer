package `in`.aika.riotdataexplorer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/summoner")
@RestController
class SummonerController {

    @GetMapping
    fun list(@RequestParam("q", required = false) q: String?) = listOf("Aikain#SOLA", "Aikain#EUW", q).filterNotNull()
}
