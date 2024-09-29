package `in`.aika.riotdataexplorer.api.routing

// https://developer.riotgames.com/docs/lol#routing-values_regional-routing-values
enum class LolRegion {
    AMERICAS,
    ASIA,
    EUROPE,
    SEA;

    val host = "${name.lowercase()}.api.riotgames.com"
}
