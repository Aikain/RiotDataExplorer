package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionSpell(
    val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val leveltip: ChampionSpellLevelTip,
    val maxrank: Int,
    val cooldown: List<Int>,
    val cooldownBurn: String,
    val cost: List<Int>,
    val costBurn: String,
    val datavalues: Any,
    val effect: List<List<Int>>, // TODO: first is null
    val effectBurn: List<String>, // TODO: first is null
    val vars: List<Any>,
    val costType: String,
    val maxammo: String,
    val range: List<Int>,
    val rangeBurn: String,
    val image: Image,
    val resource: String,
) : LogIgnoredProperties()
