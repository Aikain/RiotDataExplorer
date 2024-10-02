package `in`.aika.riotdataexplorer.api.model.data.wrapper

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ItemWrapper<Data : DataFiller<Data>>(
    val type: String,
    val version: String,
    val data: Map<String, Data>,

    // TODO: useless?
    val basic: Any,
    val groups: Any,
    val tree: Any,
) : LogIgnoredProperties() {

    fun getFilledData(): Map<String, Data> = data.mapValues { it.value.getFilledData(version) }
}
