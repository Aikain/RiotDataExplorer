package `in`.aika.riotdataexplorer.controller

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.domain.Views
import `in`.aika.riotdataexplorer.domain.current.CurrentGame
import `in`.aika.riotdataexplorer.domain.match.Match
import `in`.aika.riotdataexplorer.service.AccountService
import `in`.aika.riotdataexplorer.service.DataDragonService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RequestMapping("/account")
@RestController
class AccountController(
    private val accountService: AccountService,
    private val dataDragonService: DataDragonService,
) {

    @JsonView(Views.AccountList::class)
    @GetMapping
    fun list(@RequestParam("q", required = false) q: String?, pageable: Pageable) =
        accountService.findByQ(q, pageable).toList()

    @JsonView(Views.AccountGet::class)
    @GetMapping("{gameName}/{tagLine}")
    fun get(@PathVariable("gameName") gameName: String, @PathVariable("tagLine") tagLine: String) =
        dataDragonService.fillStaticData(accountService.getAccount(gameName, tagLine))

    @JsonView(Views.MatchList::class)
    @GetMapping("{gameName}/{tagLine}/matches")
    fun matches(
        @PathVariable("gameName") gameName: String, @PathVariable("tagLine") tagLine: String
    ): List<Match<*>> = listOf() // TODO

    @JsonView(Views.CurrentGameGet::class)
    @GetMapping("{gameName}/{tagLine}/now")
    fun currentGame(
        @PathVariable("gameName") gameName: String, @PathVariable("tagLine") tagLine: String
    ): CurrentGame<*, *> = accountService.getCurrentGame(gameName, tagLine) ?: throw ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Current game not found"
    )
}
