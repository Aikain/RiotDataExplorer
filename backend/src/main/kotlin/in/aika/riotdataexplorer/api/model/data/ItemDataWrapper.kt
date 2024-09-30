package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ItemDataWrapper(
    val type: String,
    val version: String,
    val basic: Any,
    val data: Map<String, Item>,
) : LogIgnoredProperties()
