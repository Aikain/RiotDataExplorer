package `in`.aika.riotdataexplorer.api.routing

enum class ValRegion {
    AP,
    BR,
    EU,
    KR,
    LATAM,
    NA;

    val host = "${name.lowercase()}.api.riotgames.com"
}
