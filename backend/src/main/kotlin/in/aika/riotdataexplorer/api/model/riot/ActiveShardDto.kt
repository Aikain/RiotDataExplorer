package `in`.aika.riotdataexplorer.api.model.riot

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ActiveShardDto(
    val puuid: String,
    val game: Game,
    val activeShard: ActiveShard,
) : LogIgnoredProperties()
