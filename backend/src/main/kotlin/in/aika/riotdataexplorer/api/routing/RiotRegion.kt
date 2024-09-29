package `in`.aika.riotdataexplorer.api.routing

// https://developer.riotgames.com/apis#account-v1
// There are three routing values for account-v1; americas, asia, and europe. You can query for any account in any
// region. We recommend using the nearest cluster.
enum class RiotRegion {
    AMERICAS,
    ASIA,
    // ESPORTS,
    EUROPE;

    val host = "${name.lowercase()}.api.riotgames.com"
}
