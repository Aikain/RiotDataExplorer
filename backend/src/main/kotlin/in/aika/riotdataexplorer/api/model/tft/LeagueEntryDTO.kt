package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "queueType",
    defaultImpl = LeagueBasicEntryDTO::class,
    visible = true,
)
@JsonSubTypes(
    Type(value = LeagueTurboEntryDTO::class, name = "RANKED_TFT_TURBO"),
)
sealed class LeagueEntryDTO : LogIgnoredProperties() {
    abstract val puuid: String; // encrypted
    abstract val summonerId: String; // not encrypted when queueType == RANKED_TFT_DOUBLE_UP ?
    abstract val queueType: String;

    abstract val wins: Int;
    abstract val losses: Int;
}
