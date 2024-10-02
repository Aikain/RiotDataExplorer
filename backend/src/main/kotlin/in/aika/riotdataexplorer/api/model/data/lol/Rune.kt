package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Rune(
    val id: Long,
    val key: String,
    val icon: String,
    val name: String,
    val shortDesc: String,
    val longDesc: String,
) : LogIgnoredProperties()
