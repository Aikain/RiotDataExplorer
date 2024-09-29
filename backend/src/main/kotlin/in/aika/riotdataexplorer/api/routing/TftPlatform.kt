package `in`.aika.riotdataexplorer.api.routing

enum class TftPlatform {
    BR1,
    EUN1,
    EUW1,
    JP1,
    KR,
    LA1,
    LA2,
    ME1,
    NA1,
    OC1,
    PH2,
    RU,
    SG2,
    TH2,
    TR1,
    TW2,
    VN2;

    val host = "${name.lowercase()}.api.riotgames.com"

    // https://developer.riotgames.com/apis#tft-match-v1
    // The AMERICAS routing value serves NA, BR, LAN and LAS. The ASIA routing value serves KR and JP. The EUROPE
    // routing value serves EUNE, EUW, TR, ME1, and RU. The SEA routing value serves OCE.
    fun toRegion(): TftRegion = when (this) {
        NA1, BR1, LA1, LA2 -> TftRegion.AMERICAS
        KR, JP1 -> TftRegion.ASIA
        EUN1, EUW1, TR1, ME1, RU -> TftRegion.EUROPE
        OC1, PH2, SG2, TH2, TW2, VN2 -> TftRegion.SEA
    }
}
