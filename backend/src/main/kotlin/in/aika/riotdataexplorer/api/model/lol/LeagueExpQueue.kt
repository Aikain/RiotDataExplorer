package `in`.aika.riotdataexplorer.api.model.lol

enum class LeagueExpQueue {
    // Riot API wants small 'x'
    // @JsonProperty etc. not working, because @PathVariable's isn't handled with jackson
    RANKED_SOLO_5x5,
    RANKED_TFT,
    RANKED_FLEX_SR,
    RANKED_FLEX_TT,
}
