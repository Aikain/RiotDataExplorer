package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionSpellLevelTip(
    val label: List<String>,
    val effect: List<String>,
) : LogIgnoredProperties()
