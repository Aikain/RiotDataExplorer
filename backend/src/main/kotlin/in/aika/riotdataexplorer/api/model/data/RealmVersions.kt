package `in`.aika.riotdataexplorer.api.model.data

import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class RealmVersions(
    val item: String,
    val rune: String,
    val mastery: String,
    val summoner: String,
    val champion: String,
    @JsonProperty("profileicon")
    val profileIcon: String,
    val map: String,
    val language: String,
    val sticker: String,
): LogIgnoredProperties()
