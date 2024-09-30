package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class DataWrapper<Data>(
    val type: String,
    val version: String,
    val data: Map<String, Data>,
) : LogIgnoredProperties()
