package `in`.aika.riotdataexplorer.api.model.data.general

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.domain.Views

data class Image(
    val full: String,
    val sprite: String,
    val group: String,

    @JsonView(
        Views.SummonerList::class,
    )
    val x: Int,

    @JsonView(
        Views.SummonerList::class,
    )
    val y: Int,

    @JsonView(
        Views.SummonerList::class,
    )
    val w: Int,

    @JsonView(
        Views.SummonerList::class,
    )
    val h: Int,
) : LogIgnoredProperties() {
    @JsonView(
        Views.SummonerList::class,
    )
    lateinit var url: String

    @JsonView(
        Views.SummonerList::class,
    )
    lateinit var spriteUrl: String

    companion object {
        val UNKNOWN = Image("", "", "" , 0,0,0,0)
    }

    fun updateUrls(version: String) {
        url = "https://ddragon.leagueoflegends.com/cdn/$version/img/${group}/${full}"
        spriteUrl = "https://ddragon.leagueoflegends.com/cdn/$version/img/sprite/${sprite}"
    }
}
