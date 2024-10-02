package `in`.aika.riotdataexplorer.api.model.data.wrapper

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class DeepDataWrapper<Data : DataFiller<Data>>(
    val type: String,
    val version: String,
    val data: Map<String, Map<String, Data>>,
) : LogIgnoredProperties() {

    fun getFilledData(): Map<String, Map<String, Data>> = data.mapValues {
        it.value.mapValues {
            it.value.getFilledData(version)
        }
    }
}
