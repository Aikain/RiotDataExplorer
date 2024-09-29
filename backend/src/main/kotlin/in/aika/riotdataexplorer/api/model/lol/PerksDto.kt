package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PerksDto(
    val statPerks: PerkStatsDto,
    val styles: List<PerkStyleDto>,
) : LogIgnoredProperties()
