package `in`.aika.riotdataexplorer.api.model

data class SummonerDTO(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val id: String,
    val puuid: String,
    val summonerLevel: Long,
)
