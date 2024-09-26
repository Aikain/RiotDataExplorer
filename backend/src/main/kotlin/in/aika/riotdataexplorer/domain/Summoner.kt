package `in`.aika.riotdataexplorer.domain

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.SummonerDTO

data class Summoner(
    val id: String,
    val puuid: String,
    val accountId: String,
    val revisionDate: Long,

    val profileIconId: Int,

    @field:JsonView(Views.SummonerGet::class)
    val summonerLevel: Long,
) {

    constructor(summonerDTO: SummonerDTO) : this(
        summonerDTO.id,
        summonerDTO.puuid,
        summonerDTO.accountId,
        summonerDTO.revisionDate,
        summonerDTO.profileIconId,
        summonerDTO.summonerLevel,
    )

    @JsonView(Views.SummonerGet::class)
    fun profileIcon() = "https://ddragon.leagueoflegends.com/cdn/14.19.1/img/profileicon/$profileIconId.png"
}
