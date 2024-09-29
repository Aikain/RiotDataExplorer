package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ObjectivesDto(
    val baron: ObjectiveDto,
    val champion: ObjectiveDto,
    val dragon: ObjectiveDto,
    val horde: ObjectiveDto,
    val inhibitor: ObjectiveDto,
    val riftHerald: ObjectiveDto,
    val tower: ObjectiveDto,
) : LogIgnoredProperties()
