package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PositionDto(
    val x: Int,
    val y: Int,
) : LogIgnoredProperties()
