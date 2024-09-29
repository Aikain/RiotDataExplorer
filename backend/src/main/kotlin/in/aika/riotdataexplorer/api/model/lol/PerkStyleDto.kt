package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PerkStyleDto(
    val description: String,
    val selections: List<PerkStyleSelectionDto>,
    val style: Int,
) : LogIgnoredProperties()
