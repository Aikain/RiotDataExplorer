package `in`.aika.riotdataexplorer.api.model.data.lol

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
) : LogIgnoredProperties() {

    companion object {
        val UNKNOWN = ChampionStats(
            0,
            0,
            0,
            0f,
            0,
            0,
            0f,
            0,
            0f,
            0,
            0f,
            0f,
            0f,
            0f,
            0,
            0,
            0,
            0f,
            0f,
            0f,
        )
    }
}
