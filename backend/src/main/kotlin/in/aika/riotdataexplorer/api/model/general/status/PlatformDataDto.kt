package `in`.aika.riotdataexplorer.api.model.general.status

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PlatformDataDto(
    val id: String,
    val name: String,
    val locales: List<String>,
    val maintenances: List<StatusDto>,
    val incidents: List<StatusDto>,
) : LogIgnoredProperties()
