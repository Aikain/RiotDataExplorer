package `in`.aika.riotdataexplorer.api.routing

// https://developer.riotgames.com/apis#lor-match-v1
// The AMERICAS routing value serves the AMERICAS shard. The EUROPE routing value serves the EUROPE shard. The SEA
// routing value serves the APAC shard (previously was ASIA and SEA).
enum class LorRegion {
    AMERICAS,
    ASIA,
    EUROPE;

    val host = "${name.lowercase()}.api.riotgames.com"
}
