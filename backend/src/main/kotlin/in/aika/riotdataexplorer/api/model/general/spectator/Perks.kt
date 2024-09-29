package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Perks(
    val perkIds: List<Long>,
    val perkStyle: Long,
    val perkSubStyle: Long,
) : LogIgnoredProperties()
