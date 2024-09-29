package `in`.aika.riotdataexplorer.api.routing

// https://developer.riotgames.com/docs/tft#routing-values_regional-routing-values
enum class TftRegion {
    AMERICAS,
    ASIA,
    EUROPE,
    SEA;

    val host = "${name.lowercase()}.api.riotgames.com"
}
