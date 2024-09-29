package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ClashTeamDto(
    val id: String,
    val tournamentId: Int,
    val name: String,
    val iconId: Int,
    val tier: Int,
    val captain: String, // summonerId
    val abbreviation: String,
    val players: List<PlayerDto>,
) : LogIgnoredProperties()
