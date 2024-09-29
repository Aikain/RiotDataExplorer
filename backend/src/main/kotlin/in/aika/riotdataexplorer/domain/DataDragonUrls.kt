package `in`.aika.riotdataexplorer.domain

class DataDragonUrls {
    companion object {
        private val DATA_DRAGON_BASE_URL = "https://ddragon.leagueoflegends.com/cdn/"
        private val CURRENT_VERSION = "14.19.1"
        private val FULL_BASE_URL = "$DATA_DRAGON_BASE_URL$CURRENT_VERSION"

        fun profileIconUrl(profileIconId: Int) = "$FULL_BASE_URL/img/profileicon/$profileIconId.png"
    }
}
