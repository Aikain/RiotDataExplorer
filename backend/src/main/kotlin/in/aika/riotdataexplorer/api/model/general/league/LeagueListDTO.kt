package `in`.aika.riotdataexplorer.api.model.general.league

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.util.*

data class LeagueListDTO(
    // League doesn't exists yet (or it is empty?) if leagueId is null
    val leagueId: UUID?,
    val queue: String?, // TODO: enum?
    val tier: String, // TODO: enum?
    val name: String?,
    val entries: List<LeagueItemDTO>,
) : LogIgnoredProperties()
