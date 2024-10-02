package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionSpellLevelTip(
    val label: List<String>,
    val effect: List<String>,
) : LogIgnoredProperties()
