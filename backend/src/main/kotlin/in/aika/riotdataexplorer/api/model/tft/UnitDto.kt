package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class UnitDto(
    val items: List<Int> = listOf(), // always empty?
    val itemNames: List<String> = listOf(),

    @JsonAlias("character_id")
    val characterId: String,
    val chosen: String?,
    val name: String,
    val rarity: String,
    val tier: Int,
) : LogIgnoredProperties()
