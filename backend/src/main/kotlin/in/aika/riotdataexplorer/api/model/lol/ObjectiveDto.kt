package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ObjectiveDto(
    val first: Boolean,
    val kills: Boolean,
) : LogIgnoredProperties()
