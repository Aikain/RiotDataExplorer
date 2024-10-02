package `in`.aika.riotdataexplorer.api.model.data.wrapper

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class LanguageWrapper(
    val type: String,
    val version: String,
    val data: Map<String, String>,

    // TODO: useless?
    val tree: Any,
) : LogIgnoredProperties()
