package `in`.aika.riotdataexplorer.api.model.tft

data class LeagueTurboEntryDTO(
    override val puuid: String, // encrypted
    override val summonerId: String, // encrypted, except when queueType == RANKED_TFT_DOUBLE_UP ?
    override val queueType: String,

    override val wins: Int,
    override val losses: Int,

    val ratedTier: RatedTier,
    val ratedRating: Int,
) : LeagueEntryDTO()
