package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PerkStyleSelectionDto(
    val perk: Int,
    val var1: Int,
    val var2: Int,
    val var3: Int,
) : LogIgnoredProperties()
