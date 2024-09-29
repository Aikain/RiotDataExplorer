package `in`.aika.riotdataexplorer.api.routing

// https://developer.riotgames.com/docs/lol#routing-values_platform-routing-values
enum class LolPlatform {
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
    TR1,
    RU,
    PH2,
    SG2,
    TH2,
    TW2,
    VN2;

    val host = "${name.lowercase()}.api.riotgames.com"

    // https://developer.riotgames.com/apis#match-v5
    // The AMERICAS routing value serves NA, BR, LAN and LAS. The ASIA routing value serves KR and JP. The EUROPE
    // routing value serves EUNE, EUW, ME1, TR and RU. The SEA routing value serves OCE, PH2, SG2, TH2, TW2 and VN2.
    fun toRegion(): LolRegion = when (this) {
        NA1, BR1, LA1, LA2 -> LolRegion.AMERICAS
        KR, JP1 -> LolRegion.ASIA
        EUN1, EUW1, TR1, ME1, RU -> LolRegion.EUROPE
        OC1, PH2, SG2, TH2, TW2, VN2 -> LolRegion.SEA
    }

    companion object {
        fun byRegion(region: LolRegion): List<LolPlatform> = when (region) {
            LolRegion.AMERICAS -> listOf(NA1, BR1, LA1, LA2)
            LolRegion.ASIA -> listOf(KR, JP1)
            LolRegion.EUROPE -> listOf(EUN1, EUW1, TR1, ME1, RU)
            LolRegion.SEA -> listOf(OC1, PH2, SG2, TH2, TW2, VN2)
        }

        fun fromTagLine(tagLine: String): LolPlatform? = when (tagLine) {
            "BR1", "BR" -> BR1
            "LA1", "LAN" -> LA1
            "LA2", "LAS" -> LA2
            "OC1", "OCE" -> OC1
            "NA", "NA1" -> NA1
            "EUW" -> EUW1
            "EUNE" -> EUN1
            "TR" -> TR1
            "RU" -> RU
            "KR" -> KR
            "JP" -> JP1
            else -> null
        }
    }
}
