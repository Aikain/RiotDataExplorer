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

    fun toTftPlatform(): TftPlatform = when (this) {
        BR1 -> TftPlatform.BR1
        EUN1 -> TftPlatform.EUN1
        EUW1 -> TftPlatform.EUW1
        JP1 -> TftPlatform.JP1
        KR -> TftPlatform.KR
        LA1 -> TftPlatform.LA1
        LA2 -> TftPlatform.LA2
        ME1 -> TftPlatform.ME1
        NA1 -> TftPlatform.NA1
        OC1 -> TftPlatform.OC1
        TR1 -> TftPlatform.TR1
        RU -> TftPlatform.RU
        PH2 -> TftPlatform.PH2
        SG2 -> TftPlatform.SG2
        TH2 -> TftPlatform.TH2
        TW2 -> TftPlatform.TW2
        VN2 -> TftPlatform.VN2
    }

    fun toDataDragonRealm(): String = when (this) {
        BR1 -> "br"
        EUN1 -> "eune"
        EUW1 -> "euw"
        JP1 -> "jp"
        KR -> "kr"
        LA1 -> "lan"
        LA2 -> "las"
        ME1 -> "na" // TODO: replace with correct realm
        NA1 -> "na"
        OC1 -> "oce"
        TR1 -> "tr"
        RU -> "ru"
        PH2 -> "ph"
        SG2 -> "sg"
        TH2 -> "th"
        TW2 -> "tw"
        VN2 -> "vn"
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
