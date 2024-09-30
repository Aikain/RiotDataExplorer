package `in`.aika.riotdataexplorer.api.model.data

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ProfileIcon(
    val id: String,
    val image: Image,
) : LogIgnoredProperties()
