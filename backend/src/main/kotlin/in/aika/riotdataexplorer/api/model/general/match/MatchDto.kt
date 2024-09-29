package `in`.aika.riotdataexplorer.api.model.general.match

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MatchDto<InfoDto>(
    val metadata: MetadataDto,
    val info: InfoDto,
) : LogIgnoredProperties()
