package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Item(
    val name: String,
    val description: String,
    val colloq: String,
    val plaintext: String,
    val info: List<String>,
    val image: Image,
    val gold: ItemGold,
    val tags: List<String>,
    val maps: Map<String, Boolean>,
    val stats: Map<String, Int>,
) : LogIgnoredProperties()
