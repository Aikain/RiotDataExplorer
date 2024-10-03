package `in`.aika.riotdataexplorer.controller

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.domain.Views
import `in`.aika.riotdataexplorer.domain.match.Match
import `in`.aika.riotdataexplorer.service.MatchService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RequestMapping("/match")
@RestController
class MatchController(
    private val matchService: MatchService,
) {

    @JsonView(Views.MatchGet::class)
    @GetMapping("{matchId}")
    fun matches(@PathVariable("matchId") matchId: String): Match<*> =
        matchService.findMatch(matchId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Match not found with given id"
        )
}
