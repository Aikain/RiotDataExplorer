package `in`.aika.riotdataexplorer.api.model.data.wrapper

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ChampionWrapper<Data : DataFiller<Data>>(
    val type: String,
    val format: String, // TODO: enum? full, standAloneComplex
    val version: String,
    val data: Map<String, Data>,
) : LogIgnoredProperties() {

    fun getFilledData(): Map<String, Data> = data.mapValues { it.value.getFilledData(version) }
}
