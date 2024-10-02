package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class RuneSlot(
    val runes: List<Rune>,
) : LogIgnoredProperties()
