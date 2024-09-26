package `in`.aika.riotdataexplorer.controller

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.domain.Views
import `in`.aika.riotdataexplorer.service.SummonerService
import org.springframework.web.bind.annotation.*

@RequestMapping("/summoner")
@RestController
class SummonerController(val summonerService: SummonerService) {

    @GetMapping
    fun list(@RequestParam("q", required = false) q: String?) =
        summonerService.list(q)

    @JsonView(Views.SummonerGet::class)
    @GetMapping("{gameName}/{tagLine}")
    fun get(@PathVariable("gameName") gameName: String, @PathVariable("tagLine") tagLine: String) =
        summonerService.getSummoner(gameName, tagLine)
}
