package `in`.aika.riotdataexplorer.api.model.general.spectator

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class FeaturedGames(
    val gameList: List<FeaturedGameInfo>,

    // The suggested interval to wait before requesting FeaturedGames again
    val clientRefreshInterval: Long,
) : LogIgnoredProperties()
