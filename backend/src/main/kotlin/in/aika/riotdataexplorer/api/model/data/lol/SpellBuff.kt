package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class SpellBuff(
    val id: Long,
    val name: String,
) : LogIgnoredProperties()
