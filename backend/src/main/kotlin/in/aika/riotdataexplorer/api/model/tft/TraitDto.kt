package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class TraitDto(
    val name: String,

    @JsonAlias("num_units")
    val numUnits: Int,
    val style: Int, // 0 = No style, 1 = Bronze, 2 = Silver, 3 = Gold, 4 = Chromatic

    @JsonAlias("tier_current")
    val tierCurrent: Int,

    @JsonAlias("tier_total")
    val tierTotal: Int,
) : LogIgnoredProperties()
