package `in`.aika.riotdataexplorer.api.model.data.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ItemGold(
    val base: Int,
    val purchasable: Boolean,
    val total: Int,
    val sell: Int,
) : LogIgnoredProperties()
