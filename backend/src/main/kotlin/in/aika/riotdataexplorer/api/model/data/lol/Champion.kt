package `in`.aika.riotdataexplorer.api.model.data.lol

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.api.model.data.general.Image
import `in`.aika.riotdataexplorer.api.model.data.wrapper.DataFiller
import `in`.aika.riotdataexplorer.domain.Views

data class Champion(
    val id: String,
    val key: String,

    @JsonView(Views.CurrentGameGet::class)
    val name: String,
    val title: String,

    @JsonView(Views.CurrentGameGet::class)
    val image: Image,
    val skins: List<ChampionSkin>,
    val lore: String,
    val blurb: String,
    val allytips: List<String>,
    val enemytips: List<String>,
    val tags: List<String>,
    val partype: String,
    val info: ChampionInfo,
    val stats: ChampionStats,
    val spells: List<ChampionSpell>,
    val passive: ChampionPassive,

    @JsonIgnore
    val recommended: List<Any>,
) : LogIgnoredProperties(), DataFiller<Champion> {

    companion object {
        val UNKNOWN = Champion(
            "UNKNOWN",
            "0",
            "",
            "",
            Image.UNKNOWN.apply { updateUrls("") },
            listOf(),
            "",
            "",
            listOf(),
            listOf(),
            listOf(),
            "",
            ChampionInfo.UNKNOWN,
            ChampionStats.UNKNOWN,
            listOf(),
            ChampionPassive.UNKNOWN,
            listOf(),
        )
    }

    override fun getFilledData(version: String): Champion = this.apply {
        image.updateUrls(version)
        spells.forEach {
            it.image.updateUrls(version)
        }
        passive.image.updateUrls(version)
        skins.forEach {
            it.splashImgUrl = "https://ddragon.leagueoflegends.com/cdn/$version/img/champion/splash/${id}_${it.num}.jpg"
            it.loadingImgUrl = "https://ddragon.leagueoflegends.com/cdn/$version/img/champion/loading/${id}_${it.num}.jpg"
        }
    }
}
