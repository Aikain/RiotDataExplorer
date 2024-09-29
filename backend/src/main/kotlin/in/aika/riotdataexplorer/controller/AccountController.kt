package `in`.aika.riotdataexplorer.controller

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.domain.Views
import `in`.aika.riotdataexplorer.service.AccountService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RequestMapping("/account")
@RestController
class AccountController(val accountService: AccountService) {

    @JsonView(Views.AccountList::class)
    @GetMapping
    fun list(@RequestParam("q", required = false) q: String?, pageable: Pageable) =
        accountService.findByQ(q, pageable).toList()

    @JsonView(Views.AccountGet::class)
    @GetMapping("{gameName}/{tagLine}")
    fun get(@PathVariable("gameName") gameName: String, @PathVariable("tagLine") tagLine: String) =
        accountService.getAccount(gameName, tagLine)
}
