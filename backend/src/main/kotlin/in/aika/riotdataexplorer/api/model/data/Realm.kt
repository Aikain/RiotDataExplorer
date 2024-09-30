package `in`.aika.riotdataexplorer.api.model.data

import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class Realm(
    val n: RealmVersions,
    val v: String,
    val l: String,
    val cdn: String,
    val dd: String,
    val lg: String,
    val css: String,
    @JsonProperty("profileiconmax")
    val profileIconMax: Int,
    val store: String?
) : LogIgnoredProperties()
