package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Champion(
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val image: Image,
    val skins: List<ChampionSkin>,
    val lore: String,
    val blurb: String,
    val allutips: List<String>,
    val enemytips: List<String>,
    val tags: List<String>,
    val partype: String,
    val info: ChampionInfo,
    val stats: ChampionStats,
    val spells: List<ChampionSpell>,
    val passive: ChampionPassive,
    val recommended: List<Any>,
) : LogIgnoredProperties()
