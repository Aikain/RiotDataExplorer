package `in`.aika.riotdataexplorer.api.client.lol

import `in`.aika.riotdataexplorer.api.model.lol.ClashTeamDto
import `in`.aika.riotdataexplorer.api.model.lol.PlayerDto
import `in`.aika.riotdataexplorer.api.model.lol.TournamentDto
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

// https://developer.riotgames.com/apis#clash-v1
interface LolClashApi {

    @GetExchange("/lol/clash/v1/players/by-summoner/{summonerId}")
    fun clashPlayersBySummonerId(@PathVariable summonerId: String): List<PlayerDto>

    @GetExchange("/lol/clash/v1/teams/{teamId}")
    fun clashTeamByTeamId(@PathVariable teamId: String): ClashTeamDto

    @GetExchange("/lol/clash/v1/tournaments")
    fun clashTournaments(): List<TournamentDto>

    @GetExchange("/lol/clash/v1/tournaments/by-team/{teamId}")
    fun clashTournamentByTeamId(@PathVariable teamId: String): TournamentDto

    @GetExchange("/lol/clash/v1/tournaments/{tournamentId}")
    fun clashTournamentByTournamentId(@PathVariable tournamentId: Int): TournamentDto
}
