package `in`.aika.riotdataexplorer.api.model.lol

enum class MatchType {
    // Riot API wants lowercase enums
    // @JsonProperty etc. not working, because @RequestParam's isn't handled with jackson
    ranked,
    normal,
    tourney,
    tutorial,
}
