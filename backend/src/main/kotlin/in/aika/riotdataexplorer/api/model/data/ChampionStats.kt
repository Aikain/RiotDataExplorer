package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionStats(
    val hp: Int,
    val hpperlevel: Int,
    val mp: Int,
    val mpperlevel: Float,
    val movespeed: Int,
    val armor: Int,
    val armorperlevel: Float,
    val spellblock: Int,
    val spellblockperlevel: Float,
    val attackrange: Int,
    val hpregen: Float,
    val hpregenperlevel: Float,
    val mpregen: Float,
    val mpregenperlevel: Float,
    val crit: Int,
    val critperlevel: Int,
    val attackdamage: Int,
    val attackdamageperlevel: Float,
    val attackspeedperlevel: Float,
    val attackspeed: Float
) : LogIgnoredProperties()
