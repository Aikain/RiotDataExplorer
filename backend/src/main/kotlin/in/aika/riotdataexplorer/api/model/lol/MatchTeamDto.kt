package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MatchTeamDto(
    val teamId: Int,
    val win: Boolean,
    val bans: List<BanDto>,
    val objectives: ObjectivesDto,
) : LogIgnoredProperties()
