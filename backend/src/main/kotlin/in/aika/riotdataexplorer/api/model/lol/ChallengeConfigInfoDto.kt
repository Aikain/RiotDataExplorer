package `in`.aika.riotdataexplorer.api.model.lol

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class ChallengeConfigInfoDto(
    val id: Long,
    val state: State,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val startTimestamp: OffsetDateTime?,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val endTimestamp: OffsetDateTime?,

    val localizedNames: Map<String, Map<String, String>>,
    val thresholds: Map<String, Double>,
    val leaderboard: Boolean,
    val tracking: Tracking?,
) : LogIgnoredProperties() {
    enum class State {
        DISABLED,   // not visible and not calculated
        HIDDEN,     // not visible and calculated
        ENABLED,    // visible and calculated
        ARCHIVED,   // visible and not calculated
    }

    enum class Tracking {
        LIFETIME,   // stats are incremented without reset
        SEASON,     // stats are accumulated by season and reset at the beginning of new season
    }
}
