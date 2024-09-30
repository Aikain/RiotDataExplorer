package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class SimpleChampion(
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: ChampionInfo,
    val image: Image,
    val tags: List<String>,
    val partype: String,
    val stats: ChampionStats
) : LogIgnoredProperties()
