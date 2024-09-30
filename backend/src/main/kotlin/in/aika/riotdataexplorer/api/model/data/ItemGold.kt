package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ItemGold(
    val base: Int,
    val purchasable: Boolean,
    val total: Int,
    val sell: Int,
) : LogIgnoredProperties()
